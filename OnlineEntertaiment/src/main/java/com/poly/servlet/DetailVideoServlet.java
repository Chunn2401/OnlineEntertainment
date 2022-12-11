package com.poly.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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


@WebServlet("/detail")
public class DetailVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	List<Video> list = new ArrayList<Video>();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vId = request.getParameter("id");
		VideoDao dao = new VideoDao();
		Video video = dao.findById(vId);
		String uId = SessionUtils.getLoginUsername(request);
		
		FavoriteDao favoriteDao = new FavoriteDao();
		if(favoriteDao.findFavoriteByUserAndVideo(uId,vId).isEmpty()) {
			request.setAttribute("isLike", false);
		}else {
			request.setAttribute("isLike", true);
		}
		
		UserDao userDao = new UserDao();
		int countLike = userDao.findUserLikeVideo(vId).size();
		System.out.println(video.getId());
		if(list.isEmpty()) {
			list.add(video);
			SessionUtils.add(request, "history_video", list);
			System.out.println("lan dau cua em");
		}else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("da vao dong 54---");
				
				if(!vId.equals(list.get(i).getId())) {
					list.add(video);
					SessionUtils.add(request, "history_video", list);
					System.out.println("da vao dc for va add session");
					break;
				}
				System.out.println(vId);
			}
			
		}
		
		
		List<Video> list1 = (List<Video>) SessionUtils.get(request, "history_video");
//		for (Video video1 : list1) {
//			System.out.println(video1.getTitle());
//		}
		
		
		request.setAttribute("history_video", list1);
		request.setAttribute("countLike", countLike);
		request.setAttribute("video_recomment", dao.getRandom10());
		request.setAttribute("video", video);
		request.getRequestDispatcher("/views/user/view.jsp").forward(request, response);
	}
	
	





}
