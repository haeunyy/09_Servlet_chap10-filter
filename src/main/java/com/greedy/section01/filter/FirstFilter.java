package com.greedy.section01.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/* 서블릿으로 가는 요청을 가로챌 url 패턴 작성 */
@WebFilter("/first/*")
public class FirstFilter extends HttpFilter implements Filter {
       
    /* 기본 생성자 */
    public FirstFilter() {
        System.out.println("FirstFilter 인스턴스 생성!");
    }

    /* 필터 인스턴스가 소멸 될 때 호출 되는 메소드 - 서버 종료 시 */
	public void destroy() {
		System.out.println("filter destory 호출!");
	}

	/* servlet으로 request가 전달 되기 전에 요청을 가로채는 역할 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		/* request, response의 가공을 처리하기 위해 여기에 코드를 작성한다. */
		System.out.println("filter doFilter 호출");

		/* 가공 처리를 한 뒤 다음 필터 혹은 서블릿의 service를 호출한다. */
		chain.doFilter(request, response);
		
		/* 서블릿에서 처리 후에 다시 수행할 내용이 있으면 작성한다. */
		System.out.println("서블릿 요청 처리 완료!");
	}

	/* 필터 인스턴스가 최초 생성 될 때 호출 되는 메소드 - 초기화 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter init 호출!");
	}

}



