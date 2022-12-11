package com.poly.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.FavoriteDao;
import com.poly.dao.UserDao;
import com.poly.dao.VideoDao;
import com.poly.model.Favorite;
import com.poly.model.User;
import com.poly.model.Video;
import com.poly.utils.SessionUtils;

@WebServlet("/like")
public class LikeVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uId = SessionUtils.getLoginUsername(request);
		String vId = request.getParameter("id");
		if (uId == null) {
			response.setStatus(400);
		} else {
			FavoriteDao favoriteDao = new FavoriteDao();
			if (favoriteDao.findOneFavorite(uId, vId) == null) {
				// TODO: Like
				Favorite favorite = new Favorite();
				Video video = new Video();
				User user = new User();
				Date date = new Date();
				UserDao userDao = new UserDao();
				
				video.setId(vId);
				favorite.setVideo(video);
				user.setId(uId);
				favorite.setUser(user);
				favorite.setLikeDate(date);

				favoriteDao.insert(favorite);
				int countLike = userDao.findUserLikeVideo(vId).size();
				System.out.println("Đã like video " + vId);
				response.getWriter().print(countLike);
			} else {
				UserDao userDao = new UserDao();
				favoriteDao.unlike(favoriteDao.findOneFavorite(uId, vId));
				int countLike = userDao.findUserLikeVideo(vId).size();
				System.out.println("Đã unlike video " + vId);
				response.getWriter().print(countLike);
			}

		}
	}

}
