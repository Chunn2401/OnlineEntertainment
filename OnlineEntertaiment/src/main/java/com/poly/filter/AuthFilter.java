package com.poly.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.model.User;

@WebFilter({"/account/edit-profile",
		"/account/change-password",
		"/account/sign-out",
		"/account/favorite",
		"/dashboard/homepage",
		"/dashboard/members/*",
		"/dashboard/video/*",
		"/dashboard/analytics/*"
		})
public class AuthFilter extends HttpFilter implements Filter {
       
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		String uri = request.getRequestURI();
		
		User user = (User) request.getSession().getAttribute("user");
		String error = "";
		if (user == null) {
			System.out.println("khong co sessicon");
			error = response.encodeURL("Vui lòng đăng nhập!");
		}else if (!user.getAdmin() && uri.contains("/dashboard/")) {
			System.out.println("co session");
			error = response.encodeURL("Vui lòng đăng nhập với vai trò admin!");
		}
		if (!error.isEmpty()) {
			response.sendRedirect("/OnlineEntertaiment/account/sign-in?error="+response.encodeURL(error));
		}else {
			chain.doFilter(request, response);
		}
	}
}