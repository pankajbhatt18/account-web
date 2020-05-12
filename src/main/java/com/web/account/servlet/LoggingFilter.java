package com.web.account.servlet;
/*
 * package com.demo.servlet;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.Filter; import javax.servlet.FilterChain; import
 * javax.servlet.FilterConfig; import javax.servlet.ServletException; import
 * javax.servlet.ServletRequest; import javax.servlet.ServletResponse; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.beans.factory.InitializingBean; import
 * org.springframework.beans.factory.annotation.Autowired;
 * 
 * import com.demo.model.EventLogging; import
 * com.demo.service.RecordEventService;
 * 
 * public class LoggingFilter implements Filter,InitializingBean {
 * 
 * @Autowired private RecordEventService recordEventservice;
 * 
 * @Override public void init(FilterConfig filterConfig) throws ServletException
 * { Filter.super.init(filterConfig); recordEventservice.run(); }
 * 
 * @Override public void doFilter(ServletRequest request, ServletResponse
 * response, FilterChain chain) throws IOException, ServletException {
 * HttpServletRequest httpRequest=(HttpServletRequest)request;
 * HttpServletResponse httpResponse=(HttpServletResponse)response; EventLogging
 * logging=prepareEventObject(httpRequest,httpResponse);
 * recordEventservice.recordEvent(logging); }
 * 
 * @Override public void destroy() { }
 * 
 * private EventLogging prepareEventObject(HttpServletRequest httpRequest,
 * HttpServletResponse httpResponse) { EventLogging logging =new EventLogging();
 * logging.setMethod(httpRequest.getMethod());
 * logging.setResponseCode(Integer.toString(httpResponse.getStatus()));
 * logging.setDetails(getDetails(httpRequest,httpResponse)); return logging; }
 * 
 * 
 * private String getDetails(HttpServletRequest httpRequest, HttpServletResponse
 * httpResponse) { StringBuilder logDetails=new StringBuilder();
 * logDetails.append("Rest-API-"+httpRequest.getRequestURI()); return
 * logDetails.toString(); }
 * 
 * 
 * @Override public void afterPropertiesSet() throws Exception { } }
 */