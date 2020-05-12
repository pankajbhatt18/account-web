/*@Header
 *@Author:Pankaj 
 */
package com.web.account;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.account.service.AuthenticationService;

/**
 * The Class RestAuthenticationFilter.
 */
public class RestAuthenticationFilter implements javax.servlet.Filter {
	
	/** The Constant AUTHENTICATION_HEADER. */
	public static final String AUTHENTICATION_HEADER = "Authorization";

	/** The authentication service. */
	@Autowired
	private AuthenticationService authenticationService;
	
	/**
	 * Do filter.
	 *
	 * @param request the request
	 * @param response the response
	 * @param filter the filter
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			String authCredentials = httpServletRequest
					.getHeader(AUTHENTICATION_HEADER);
			boolean authenticationStatus = authenticationService.authenticate(authCredentials,httpServletRequest);
			if (authenticationStatus) {
				filter.doFilter(request, response);
			} else {
				if (response instanceof HttpServletResponse) {
					HttpServletResponse httpServletResponse = (HttpServletResponse) response;
					httpServletResponse
							.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}
			}
		}
	}
	
	/**
	 * Destroy.
	 */
	@Override
	public void destroy() {
	}
	
	/**
	 * Inits the.
	 *
	 * @param arg0 the arg 0
	 * @throws ServletException the servlet exception
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}