package com.poly.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.model.Favorite;
import com.poly.model.User;
import com.poly.utils.SessionUtils;

@WebServlet("/account/favorite")
public class FavoriteVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FavoriteVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) SessionUtils.get(request, "user");
				
		List<Favorite> favorites = user.getFavorites();
				
		request.setAttribute("items_favorite", favorites);
		System.out.println("chay yeu thich");
		try {
			request.getRequestDispatcher("/views/user/favorite.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}



}
