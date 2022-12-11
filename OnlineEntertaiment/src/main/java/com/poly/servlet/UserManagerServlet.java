package com.poly.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.UserDao;
import com.poly.model.User;
import com.poly.utils.SessionUtils;

@WebServlet({ "/dashboard/members", "/dashboard/members/create", "/dashboard/members/update",
		"/dashboard/members/delete", "/dashboard/members/edit", "/dashboard/members/reset" })
public class UserManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		User user = (User) SessionUtils.get(request, "user");

		String url = request.getRequestURL().toString();
		if (url.contains("delete")) {
			delete(request, response);
			user = new User();
			request.setAttribute("user", user);
		} else if (url.contains("edit")) {
			edit(request, response);
		} else if (url.contains("reset")) {
			user = new User();
			request.setAttribute("user", user);
		}

		findAll(request, response);
		try {
			request.getRequestDispatcher("/views/admin/members.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		String url = request.getRequestURL().toString();

		if (url.contains("create")) {
			insert(request, response);
		} else if (url.contains("update")) {
			update(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
			request.setAttribute("user", new User());
		} else if (url.contains("reset")) {
			request.setAttribute("user", new User());
		}
		findAll(request, response);
		try {
			request.getRequestDispatcher("/views/admin/members.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			UserDao daoUser = new UserDao();
			daoUser.insert(user);
			request.setAttribute("message", "User inserted!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			UserDao daoUser = new UserDao();
			daoUser.update(user);
			request.setAttribute("user", user);
			request.setAttribute("message", "User Updated!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			UserDao dao = new UserDao();
			dao.delete(id);
			request.setAttribute("message", "User Deleted!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");

			UserDao daoUser = new UserDao();
			User user = daoUser.findById(id);

			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserDao dao = new UserDao();

			List<User> list = dao.findAll();

			request.setAttribute("users", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

}
