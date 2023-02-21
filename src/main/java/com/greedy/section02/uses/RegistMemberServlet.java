package com.greedy.section02.uses;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.SetCharacterEncodingFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 1. 인코딩 필터
		 * 2. 암호화 필터
		 * */
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		System.out.println(userId);
		System.out.println(password);
		System.out.println(name);
		
		/* 암호화 처리 된 패스워드는 동일한 값이 입력되더라도 랜덤 솔팅 기법에 의해 매번 다른 값을 가지게 된다. 
		 * 나중에 DB에 이상태로 기록하게 되면 가입된 회원정보로 로그인 할 때 비밀번호가 같은지는 어떻게 비교할 수 있을까? 
		 * 암호화 된 문자열은 일반 문자열 비교가 불가능 하고 BCryptpasswordEncoder의 match라는 메소드를 사용한다. 
		 * */
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println("비밀번호가 pass01인지 확인 : "+passwordEncoder.matches("pass01", password));
		System.out.println("비밀번호가 pass02인지 확인 : "+passwordEncoder.matches("pass02", password));
		
		
		
		
	}

}
