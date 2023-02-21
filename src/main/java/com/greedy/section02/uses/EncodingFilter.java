package com.greedy.section02.uses;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/* 필터 등록은 web.xml에서 처리 -> 배포서술자 xml 안만들었다면 javaEE옵션에서 GDD에서 가능*/
public class EncodingFilter extends HttpFilter implements Filter {
	
	private String encodingType;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// doget에서는 필요가 없어서 get인지 post인지 확인하자 
		// getMethod()를 사용할 수 없다. request의 타입이 HttpServletResponse이 아니고 상위타입으로 들어오게 되어 다운캐스팅해서 확인한다.
		/* POST 방식으로 요청 되었을 경우 문자 인코딩이 필요하므로 확인해서 인코딩 설정 */
		HttpServletRequest hrequest = (HttpServletRequest)request;
		if("POST".equals(hrequest.getMethod())){
			request.setCharacterEncoding(encodingType);
		}
		
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
		// xml의 encoding-type이 문자열로 변수에 담긴다. 
		/* web.xml 에서 필터 등록시 기재한 init-param의 key를 이용해서 fconfig에서 꺼낼 수 있다. */
		encodingType = fConfig.getInitParameter("encoding-type");
	}
	
}
