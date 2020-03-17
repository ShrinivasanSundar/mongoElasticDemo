//package com.example.demo.config;
//
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.MDC;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//public class Interceptor implements HandlerInterceptor {
//
//	  @Override
//	  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//		System.out.println("Entered Interceptor");
//		UUID requestId = UUID.randomUUID();
//	    MDC.clear();
//	    MDC.put("requestId", String.valueOf(requestId));
//	    return true;
//	  }
//}
