/**
 * 
 */
package com.hnexus.esmd.request.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.hnexus.esmd.admins.domain.Admin;
import com.hnexus.esmd.commons.utils.CommonUtils;
import com.hnexus.esmd.commons.utils.Constants;
import com.hnexus.esmd.request.dao.ClaimRequestDao;
import com.hnexus.esmd.request.domain.ClaimRequest;
import com.hnexus.esmd.validators.ClaimRequestFromValidator;

/**
 * @author user
 *
 */
@Controller
public class ClaimRequestController {
	@Autowired
	private ClaimRequestDao oClaimRequestDao;
	@Autowired
	private ClaimRequestFromValidator claimRequestFromValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		//binder.registerCustomEditor(String.class, new StringMultipartFileEditor());
	}
	
	@RequestMapping(value = "/saveRequest", method = RequestMethod.GET)
	public ModelAndView newAdminForm() {
		ModelAndView mav = new ModelAndView("claimRequest");
		ClaimRequest oClaimRequest = new ClaimRequest();
		mav.getModelMap().put("claimRequest", oClaimRequest);
		return mav;
	}

	@RequestMapping(value = "/saveRequest", method = RequestMethod.POST)
	public String create(@ModelAttribute("claimRequest") ClaimRequest oClaimRequest,
			BindingResult result, SessionStatus status, HttpServletRequest request) {
		claimRequestFromValidator.validate(oClaimRequest, result);
		HttpSession session = request.getSession(false);
		Admin oAdmin = (Admin)session.getAttribute("LOGGEDINUSER");
		if (result.hasErrors()) {
			return "claimRequest";
		}
		String esmdRequestId = null;
		if(oClaimRequest.getEsmdRequestId() != null && !oClaimRequest.getEsmdRequestId().isEmpty() && !oClaimRequest.getEsmdRequestId().trim().isEmpty()){
			esmdRequestId = oClaimRequest.getEsmdRequestId();
		} else {
			esmdRequestId = CommonUtils.generateUUID();
		}
		String filePath = "C:\\hnexusesmduploads\\";
		File file = null;
		try {

			MultipartFile filea = oClaimRequest.getEsmdUploadDocument();

			InputStream inputStream = null;
			OutputStream outputStream = null;
			
			if (filea.getSize() > 0) {
				inputStream = filea.getInputStream();
				file = new File(filePath);
				if (!file.exists()) {
					file.mkdirs();
		            boolean bval = file.setExecutable(true,false);
		            System.out.println("set the everybody execute permission: "+ bval);
		        }
				filePath = filePath + filea.getOriginalFilename();
				outputStream = new FileOutputStream(filePath);
				
				int readBytes = 0;
				byte[] buffer = new byte[8192];
				while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
					outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				inputStream.close();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(file != null && file.exists()){
			File uploadedFile = new File(filePath);
			uploadedFile.delete();
			filePath = null;
		}
//		Integer esmdAuthor = CommonUtils.isNotNull(oClaimRequest.getEsmdAuthor().toString()) ? Integer .parseInt(oClaimRequest.getEsmdAuthor().toString()) : 0;
//		Integer esmdAuthorInstitution = CommonUtils.isNotNull(oClaimRequest.getEsmdAuthorInstitution().toString()) ? Integer .parseInt(oClaimRequest.getEsmdAuthorInstitution().toString()) : 0;
//		Integer esmdAuthorPerson = CommonUtils.isNotNull(oClaimRequest.getEsmdAuthorPerson().toString()) ? Integer .parseInt(oClaimRequest.getEsmdAuthorPerson().toString()) : 0;
//		oClaimRequest.setEsmdAuthor(esmdAuthor);
//		oClaimRequest.setEsmdAuthorInstitution(esmdAuthorInstitution);
//		oClaimRequest.setEsmdAuthorPerson(esmdAuthorPerson);
		if(oAdmin != null){
			oClaimRequest.setOrgnization(oAdmin.getOrganization());
			oClaimRequest.setEsmdEnteredBy(oAdmin);
			oClaimRequest.setEsmdUpdatedBy(oAdmin);
		}
		oClaimRequest.setFileName(filePath);
		oClaimRequest.setEsmdUploadDocument(null);
		oClaimRequest.setEsmdCreationDate(new Date());
		oClaimRequest.setEsmdUpdateDate(new Date());
		oClaimRequest.setEsmdRequestId(esmdRequestId);
		oClaimRequestDao.save(oClaimRequest);
		status.setComplete();
		return "redirect:viewAllClaimRequests.do";
	}

	@RequestMapping(value = "/updateRequest", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("esmdRequestId") String esmdRequestId) {
		ModelAndView mav = new ModelAndView("claimRequest");
		ClaimRequest oClaimRequest = oClaimRequestDao.getClaimRequestById(esmdRequestId);
		mav.addObject("claimRequest", oClaimRequest);
		return mav;
	}

	@RequestMapping(value = "/updateRequest", method = RequestMethod.POST)
	public String update(@ModelAttribute("claimRequest") ClaimRequest oClaimRequest,
			BindingResult result, SessionStatus status) {
		claimRequestFromValidator.validate(oClaimRequest, result);
		if (result.hasErrors()) {
			return "claimRequest";
		}
		oClaimRequestDao.update(oClaimRequest);
		status.setComplete();
		return "redirect:viewAllClaimRequests.do";
	}

	@RequestMapping("deleteRequest")
	public ModelAndView delete(@RequestParam("esmdRequestId") String esmdRequestId) {
		ModelAndView mav = new ModelAndView("redirect:viewAllClaimRequests.do");
		oClaimRequestDao.delete(esmdRequestId);
		return mav;
	}
	
	@RequestMapping("/searchClaimRequests")
	public ModelAndView searchClaimRequests(@RequestParam(required= false, defaultValue="") String esmdLastName)
	{
		ModelAndView mav = new ModelAndView("showClaimRequests");
		List<ClaimRequest> oAdmins = oClaimRequestDao.searchClaimRequests(esmdLastName.trim());
		mav.addObject("CLAIM_REQUEST_LIST", oAdmins);
		return mav;
	}
	
	@RequestMapping("/viewAllClaimRequests")
	public ModelAndView getAllClaimRequests(@RequestParam(required= false, defaultValue="") String page, @RequestParam(required= false, defaultValue="") String pageNumber)
	{
		ModelAndView mav = new ModelAndView("showClaimRequests");
		if(!CommonUtils.isNotNull(pageNumber)){
			totalLinesCount = oClaimRequestDao.getTotalClaimRequestsCount();
		}
		if("previous".equalsIgnoreCase(page)){
			Integer esmdAuthor = CommonUtils.isNotNull(pageNumber) ? Integer .parseInt(pageNumber) : 0;
			setScrollerPage(esmdAuthor);
			moveBackward();
		} else if("next".equalsIgnoreCase(page)){
			Integer esmdAuthor = CommonUtils.isNotNull(pageNumber) ? Integer .parseInt(pageNumber) : 0;
			setScrollerPage(esmdAuthor);
			moveForward();
		} else if("firstpage".equalsIgnoreCase(page)){
			Integer esmdAuthor = CommonUtils.isNotNull(pageNumber) ? Integer .parseInt(pageNumber) : 0;
			setScrollerPage(esmdAuthor);
			moveToFirstPage();
		} else if("lastpage".equalsIgnoreCase(page)){
			Integer esmdAuthor = CommonUtils.isNotNull(pageNumber) ? Integer .parseInt(pageNumber) : 0;
			setScrollerPage(esmdAuthor);
			moveToLastPage();
		} else if("currentPage".equalsIgnoreCase(page)){
			Integer esmdAuthor = CommonUtils.isNotNull(pageNumber) ? Integer .parseInt(pageNumber) : 0;
			setScrollerPage(esmdAuthor);
		} else {
			setScrollerPage(0);
		}
		List<ClaimRequest> oclaimRequestList = oClaimRequestDao.getAllClaimRequests(getScrollerPage()*getPageSize(), getPageSize());
		mav.addObject("CURRENTPAGE", getScrollerPage());
		mav.addObject("TOTALPAGES", getTotalPagesCount());
		mav.addObject("CLAIM_REQUEST_LIST", oclaimRequestList);
		return mav;
	}

	@RequestMapping(value = "/viewPaginationClaimRequest", method = RequestMethod.GET)
	public @ResponseBody String getPaginationClaimRequests(@RequestParam(required= false, defaultValue="") String page, @RequestParam(required= false, defaultValue="") String pageNumber) {
		if(!CommonUtils.isNotNull(pageNumber)){
			totalLinesCount = oClaimRequestDao.getTotalClaimRequestsCount();
		}
		if("previous".equalsIgnoreCase(page)){
			Integer esmdAuthor = CommonUtils.isNotNull(pageNumber) ? Integer .parseInt(pageNumber) : 0;
			setScrollerPage(esmdAuthor);
			moveBackward();
		} else if("next".equalsIgnoreCase(page)){
			Integer esmdAuthor = CommonUtils.isNotNull(pageNumber) ? Integer .parseInt(pageNumber) : 0;
			setScrollerPage(esmdAuthor);
			moveForward();
		} else if("firstpage".equalsIgnoreCase(page)){
			Integer esmdAuthor = CommonUtils.isNotNull(pageNumber) ? Integer .parseInt(pageNumber) : 0;
			setScrollerPage(esmdAuthor);
			moveToFirstPage();
		} else if("lastpage".equalsIgnoreCase(page)){
			Integer esmdAuthor = CommonUtils.isNotNull(pageNumber) ? Integer .parseInt(pageNumber) : 0;
			setScrollerPage(esmdAuthor);
			moveToLastPage();
		} else if("currentPage".equalsIgnoreCase(page)){
			Integer esmdAuthor = CommonUtils.isNotNull(pageNumber) ? Integer .parseInt(pageNumber) : 0;
			setScrollerPage(esmdAuthor);
		} else {
			setScrollerPage(0);
		}
		List<ClaimRequest> oclaimRequestList = oClaimRequestDao.getAllClaimRequests(getScrollerPage()*getPageSize(), getPageSize());
		StringBuffer sb = new StringBuffer();
		
		for(ClaimRequest claimReq : oclaimRequestList){
			sb.append("<tr>");
			sb.append("<td class=\"tdmain brleft brright brtop brbottom\">");
			sb.append(claimReq.getOrgnization().getEsmdOrgName()+"</td>");
			sb.append("<td class=\"tdmain brright brtop brbottom\">");
			sb.append(claimReq.getEsmdSubmissionTime()+"</td>");
			sb.append("<td class=\"tdmain brright brtop brbottom\">");
			sb.append("Status</td>");
			sb.append("<td class=\"tdmain brright brtop brbottom\">");
			sb.append("Location</td>");
			sb.append("<td class=\"tdmain brright brtop brbottom\">");
			sb.append(claimReq.getEsmdEnteredBy().getEsmdUserName()+"</td>");
			sb.append("<td class=\"tdmain brright brtop brbottom\">");
			sb.append(claimReq.getEsmdEnteredBy().getEsmdAdminId()+"</td>");
			
			sb.append("<td class=\"tdmain brright brtop brbottom\">");
			sb.append("<a href=\"updateRequest.do?esmdRequestId=");
			sb.append(claimReq.getEsmdRequestId());
			sb.append("\">Edit</a></td>");
			
			sb.append("<td class=\"tdmain brright brtop brbottom\">");
			sb.append("<a href=\"deleteRequest.do?esmdRequestId=");
			sb.append(claimReq.getEsmdRequestId());
			sb.append("\">Delete</a></td>");
			sb.append("</tr>");
		}
		
		sb.append("<tr>");
		sb.append("<td class=\"tdmain brright brtop brbottom\">");
		if(getScrollerPage() != 0){
			sb.append("<a href=\"#\" onclick=\"doAjax('firstpage','0', 'viewPaginationClaimRequest.do', 'pagination');\">First</a> / <a href=\"#\" onclick=\"doAjax('previous','"+getScrollerPage()+"', 'viewPaginationClaimRequest.do', 'pagination');\">Previous</a>");
		} else {
			sb.append("<span>First</span> / <span>Previous</span>");
		}
		sb.append("</td>");
		sb.append("<td class=\"tdmain brright brtop brbottom\">");
		//sb.append("<select name=\"pageNo\" onchange=\"OnDropDownChange(this)\">");
		sb.append("<select name=\"pageNo\" onchange=\"doAjax('currentPage', this.value, 'viewPaginationClaimRequest.do', 'pagination');\">");
		for(int i = 0; i < getTotalPagesCount(); i++){
			
			if(i == getScrollerPage()) {
				sb.append("<option value=\""+i+"\" selected>"+(i+1)+"</option>");
			} else {
				sb.append("<option value=\""+i+"\">"+(i+1)+"</option>");
			}
		}
		sb.append("</select> / "+getTotalPagesCount());
		sb.append("</td>");
		
		sb.append("<td class=\"tdmain brright brtop brbottom\">");
		if(getScrollerPage() != (getTotalPagesCount()-1)){
			sb.append("<a href=\"#\" onclick=\"doAjax('next','"+getScrollerPage()+"', 'viewPaginationClaimRequest.do', 'pagination');\">Next</a> / <a href=\"#\" onclick=\"doAjax('lastpage','"+(getTotalPagesCount()-1)+"', 'viewPaginationClaimRequest.do', 'pagination');\">Last</a>");
		} else {
			sb.append("<span>Next</span> / <span>Last</span>");
		}
		sb.append("</td>");
		
		sb.append("</tr>");
		return sb.toString();
	}

	/** Page number for the scroller component for promotional lines table. */
	private Integer scrollerPage = 0;
	/** The total number of lines. */
	private Integer totalLinesCount = 0;

	public Integer getPageSize() {
		return Constants.PERPAGE_COUNT;
	}

	/**
	 * @return the scrollerPage
	 */
	public Integer getScrollerPage() {
		return scrollerPage;
	}

	/**
	 * @param scrollerPage the scrollerPage to set
	 */
	public void setScrollerPage(Integer scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	/**
	 * @return the totalLinesCount
	 */
	public Integer getTotalLinesCount() {
		return totalLinesCount;
	}

	/**
	 * @param totalLinesCount the totalLinesCount to set
	 */
	public void setTotalLinesCount(Integer totalLinesCount) {
		this.totalLinesCount = totalLinesCount;
	}

	/**
	 * Gets the total pages count.
	 * 
	 * @return the total pages count
	 */
	public Integer getTotalPagesCount() {
		Integer result = totalLinesCount / getPageSize();
		Integer remained = totalLinesCount % getPageSize();
		if (remained > 0 || result == 0) {
			result++;
		}
		return result;
	}

	/**
	 * Move one page forward.
	 */
	public void moveForward() {
		if (getScrollerPage() < (getTotalPagesCount() - 1)) {
			setScrollerPage(this.scrollerPage + 1);
		}
	}

	/**
	 * Move one page backward.
	 */
	public void moveBackward() {
		if (getScrollerPage() > 0) {
			setScrollerPage(getScrollerPage() - 1);
		}
	}

	/**
	 * Moves to the first page.
	 */
	public void moveToFirstPage() {
		if (getScrollerPage() > 0) {
			setScrollerPage(0);
		}
	}

	/**
	 * Moves to the last page.
	 */
	public void moveToLastPage() {
		if (getScrollerPage() < (getTotalPagesCount() - 1)) {
			setScrollerPage(getTotalPagesCount() - 1);
		}
	}
	
}
