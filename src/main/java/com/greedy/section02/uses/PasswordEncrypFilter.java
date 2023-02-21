package com.greedy.section02.uses;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/* member와 관련 된 기능일 경우에만 필터를 거치도록 설정한다. */
@WebFilter("/member/*")
public class PasswordEncrypFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		/* getParameter안에 비밀번호의 암호화 기능을 재정의 하자. */
		/* 기존 request 객체를 Wrapper 객체로 변경 */
		HttpServletRequest hrequest = (HttpServletRequest) request; 
		RequestWrapper wrapper = new RequestWrapper(hrequest);
		
		chain.doFilter(wrapper, response);
		
		
	}


}
