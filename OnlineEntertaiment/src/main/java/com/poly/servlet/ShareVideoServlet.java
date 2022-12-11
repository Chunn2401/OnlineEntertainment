package com.poly.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.ShareDao;
import com.poly.dao.VideoDao;
import com.poly.model.User;
import com.poly.model.Video;
import com.poly.model.Share;
import com.poly.utils.MailUtils;
import com.poly.utils.SessionUtils;

@WebServlet("/share")
public class ShareVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uId = SessionUtils.getLoginUsername(request);
		String vId = request.getParameter("vId");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		String subject = "Share Favorite Video";
		if(vId == null) {
			System.out.println("loi id video null");
			response.setStatus(400);
		}else {
			MailUtils.sendMail(request, response, email, subject, content);
//			try {
//				User user = (User) request.getSession().getAttribute("user");
//				VideoDao videoDao = new VideoDao();
//				ShareDao shareDao = new ShareDao();
//				Video video = videoDao.findById(vId);
//				shareDao.insert(new Share(user, video, user.getEmail(), new Date()));
//				resp.sendRedirect("/ASM/detail?id=" + idVid);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
			try {
				ShareDao shareDao = new ShareDao();
				Share share = new Share();
				share.setEmail(email);
				share.setShareDate(new Date());
				
				User user = new User();
				user.setId(uId);
				
				share.setUser(user);
				Video video = new Video();
				video.setId(vId);
				share.setVideo(video);
				
				shareDao.insert(share);
			} catch (Exception e) {
				System.out.println("loi them vao db");
				response.setStatus(400);
			}
		}
		
	}

}
