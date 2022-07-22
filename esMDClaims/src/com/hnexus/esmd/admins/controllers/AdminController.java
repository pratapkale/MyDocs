/**
 * 
 */
package com.hnexus.esmd.admins.controllers;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.hnexus.esmd.admins.dao.AdminDao;
import com.hnexus.esmd.admins.domain.Admin;
import com.hnexus.esmd.validators.AdminFormValidator;
import com.hnexus.esmd.validators.LoginAdminFormValidator;

/**
 * @author user
 * 
 */
@Controller
public class AdminController {
	@Autowired
	private AdminDao oAdminDao;
	@Autowired
	private LoginAdminFormValidator loginAdminFormValidator;
	@Autowired
	private AdminFormValidator adminFormValidator;

	@RequestMapping(value = "/loginAdmin", method = RequestMethod.GET)
	public ModelAndView newLoginForm() {
		ModelAndView mav = new ModelAndView("loginAdmin");
		Admin oAdmin = new Admin();
		mav.getModelMap().put("loginAdmin", oAdmin);
		return mav;
	}

	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("loginAdmin") Admin oAdmin,
			BindingResult result, SessionStatus status,
			HttpServletRequest request) {
		String viewName = "loginAdmin";
		ModelAndView mav = new ModelAndView(viewName);
		loginAdminFormValidator.validate(oAdmin, result);
		if (result.hasErrors()) {
			return mav;
		}
		Admin objAdmin = oAdminDao.loginAuthentication(oAdmin);
		status.setComplete();

		if (objAdmin == null) {
			mav.getModel().put("ERROR", "Invalid UserName or Password");
		} else {
			viewName = "redirect:viewAllClaimRequests.do";
			request.getSession().setAttribute("LOGGEDINUSER", objAdmin);
		}
		mav.setViewName(viewName);
		return mav;
	}

	@RequestMapping(value = "/logoutAdmin", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("logoutAdmin");
		HttpSession session = request.getSession(false);
		if (session != null && session.getId() != null) {
			Long current = Calendar.getInstance().getTimeInMillis();
			Long before = current + (60 * 60 * 1000);
			current = before - current;
			session.setMaxInactiveInterval(current.intValue());
			session.invalidate();
		}
		mav.setViewName("logoutAdmin");
		return mav;
	}

	@RequestMapping(value = "/saveAdmin", method = RequestMethod.GET)
	public ModelAndView newAdminForm() {
		ModelAndView mav = new ModelAndView("adminForm");
		Admin oAdmin = new Admin();
		mav.getModelMap().put("adminForm", oAdmin);
		return mav;
	}

	@RequestMapping(value = "/saveAdmin", method = RequestMethod.POST)
	public String create(@ModelAttribute("adminForm") Admin oAdmin,
			BindingResult result, SessionStatus status) {
		adminFormValidator.validate(oAdmin, result);
		if (result.hasErrors()) {
			return "adminForm";
		}
		oAdminDao.save(oAdmin);
		status.setComplete();
		return "redirect:viewAllAdmins.do";
	}

	@RequestMapping(value = "/updateAdmin", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("esmdAdminId") String esmdAdminId) {
		ModelAndView mav = new ModelAndView("editAdminForm");
		Admin oAdmin = oAdminDao.getAdminById(esmdAdminId);
		mav.addObject("editAdminForm", oAdmin);
		return mav;
	}

	@RequestMapping(value = "/updateAdmin", method = RequestMethod.POST)
	public String update(@ModelAttribute("editAdminForm") Admin oAdmin,
			BindingResult result, SessionStatus status) {
		adminFormValidator.validate(oAdmin, result);
		if (result.hasErrors()) {
			return "editAdminForm";
		}
		oAdminDao.update(oAdmin);
		status.setComplete();
		return "redirect:viewAllAdmins.do";
	}

	@RequestMapping("deleteAdmin")
	public ModelAndView delete(@RequestParam("esmdAdminId") String esmdAdminId) {
		ModelAndView mav = new ModelAndView("redirect:viewAllAdmins.do");
		oAdminDao.delete(esmdAdminId);
		return mav;
	}
	
	@RequestMapping("/searchAdmins")
	public ModelAndView searchAdmins(@RequestParam(required= false, defaultValue="") String esmdUserName)
	{
		ModelAndView mav = new ModelAndView("showAdmins");
		List<Admin> oAdmins = oAdminDao.searchAdmins(esmdUserName.trim());
		mav.addObject("ADMINS_LIST", oAdmins);
		return mav;
	}
	
	@RequestMapping("/viewAllAdmins")
	public ModelAndView getAllAdmins()
	{
		ModelAndView mav = new ModelAndView("showAdmins");
		List<Admin> oAdmins = oAdminDao.getAllAdmins();
		mav.addObject("ADMINS_LIST", oAdmins);
		return mav;
	}
	
	@RequestMapping(value = "/sessionout", method = RequestMethod.GET)
	public ModelAndView sessionOut() {
		ModelAndView mav = new ModelAndView("sessionout");
		return mav;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
}
