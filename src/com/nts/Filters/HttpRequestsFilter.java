package com.nts.Filters;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class HttpRequestsFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
		}
					, description = "Filter all application requests", urlPatterns = { "/" })
public class HttpRequestsFilter implements Filter  {

    /**
     * Default constructor. 
     */
    public HttpRequestsFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("request  "+request);

		if(!request.isSecure())
			response.getWriter().write("Insecure Request");
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		fConfig.getServletContext().addFilter(null, HttpRequestsFilter.class);
	}

}
