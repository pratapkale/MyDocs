/**
 * 
 */
package com.hnexus.esmd.commons.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.hnexus.esmd.admins.domain.Admin;

/**
 * @author user
 *
 */
@Component
public class AuthenticationFilter implements Filter {
	List<String> uriList = null;
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		Admin oAdmin = null;
		HttpServletRequest request = (HttpServletRequest) req;
		boolean flag = false;
		String uri = request.getRequestURI();
		String pathUri = null;
		for(String strUri : uriList){
			if(uri.contains(strUri)){
				flag = true;
				pathUri = strUri;
			}
		}
		
		HttpSession session = request.getSession(false);
		if(session != null && session.getId() != null){
			oAdmin = (Admin)session.getAttribute("LOGGEDINUSER");
		}
		if(flag){
			req.getRequestDispatcher(pathUri).forward(req, resp);
		} else if(oAdmin != null){
			chain.doFilter(req, resp);
		} else if(null == oAdmin && uri != null && uri.toLowerCase().contains("Pagination".toLowerCase())){
			req.getRequestDispatcher("sessionout.do").forward(req, resp);
		} else {
			req.getRequestDispatcher("loginAdmin.do").forward(req, resp);
		}

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		uriList = new ArrayList<String>();
		uriList.add("home.do");

	}

}
