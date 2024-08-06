package edu.kh.project.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


// Filter : 클라이언트의 요청/응답을 걸러내거나 첨가하는 클래스

// client -> Filter <-> Dispatcher Servlet

//@WebFilter : 해당 클래스를 필터로 등록하고 지정된 주소로 요청이 올 때 마다 동작한다.
@WebFilter(filterName = "loginFilter" , urlPatterns="/myPage/*")
public class LoginFilter implements Filter {

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// 서버가 켜질 때, 필터 코드가 변경 되었을 때 필터가 생성됨
		// -> 생성 시 초기화 용도로 사용하는 메소드
	}
    /**
     * Default constructor. 
     */
    public LoginFilter() {
    	System.out.println("----- 로그인 필터 생성 ----");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("--- 이전 로그인 필터 파괴 ------");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// 1) ServletRequest, ServletResponse 다운 캐스팅
		HttpServletRequest req = (HttpServletRequest)request;
		// 2) HttpServletRequest를 이용해서 HttpSession 얻어오기
		HttpSession session = req.getSession();
		// 3) Session에서 "loginMember" key를 가진 속성을 얻어와
		// null인 경우 메인 페이지로 redirect 시키기
		HttpServletResponse resp = (HttpServletResponse)response;
		if(session.getAttribute("loginMember")==null) {
			
			resp.sendRedirect("/");
			
		}
		// 4) 로그인 상태인 경우 다음 필터 또는 DispatcherServlet으로 전달
		chain.doFilter(request, response);
	}



}
