//package com.onlyu.demo;
//
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletResponse;
//import javax.ws.rs.ext.Provider;
//import java.io.IOException;
//
//@Provider
//public class CORSFilterServlet implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//        resp.addHeader("Access-Control-Allow-Origin", "*");
//        resp.addHeader("Access-Control-Allow-Headers", "*");
//        resp.addHeader("Access-Control-Allow-Methods", "*");
//        filterChain.doFilter(servletRequest, resp);
//    }
//
//}
