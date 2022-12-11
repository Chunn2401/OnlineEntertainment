package com.poly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.UserDao;
import com.poly.model.User;

@WebServlet("/InsertUserServlet")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			User user = new User();
			
			user.setId("trieunhd2");
			user.setPassword("trieunhd2");
			user.setFullname("Triều Nguyễn");
			user.setEmail("trieu02@gmail.com");
			user.setAdmin(true);
			
			UserDao dao = new UserDao();
			dao.insert(user);
			System.out.println("Them moi thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
