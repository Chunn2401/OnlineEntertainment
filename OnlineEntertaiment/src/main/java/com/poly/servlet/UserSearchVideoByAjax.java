package com.poly.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.VideoDao;
import com.poly.model.Video;


@WebServlet("/search")
public class UserSearchVideoByAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/views/user/search.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String search = request.getParameter("id");
		VideoDao daoVideo = new VideoDao();
		List<Video> list = daoVideo.findByKeyWord(search);
		PrintWriter out = response.getWriter();
		
		for(Video o : list ) {
			out.println("<div class=\"col-6 col-md-2 py-3\">\r\n"
					+ "								<div class=\"bg-image hover-overlay ripple position-relative\"\r\n"
					+ "									data-mdb-ripple-color=\"light\">\r\n"
					+ "									<img src=\"/OnlineEntertaiment/uploads/"+o.getPoster()+"\"\r\n"
					+ "										class=\"img-fluid\" />\r\n"
					+ "									<div class=\"mask\"\r\n"
					+ "										style=\"background-color: rgba(251, 251, 251, 0.2)\">\r\n"
					+ "										<a href=\"/OnlineEntertaiment/detail?id="+o.getId()+"\"><i\r\n"
					+ "											class=\"far fa-play-circle fa-5x position-absolute top-50 start-50 translate-middle\"></i></a>\r\n"
					+ "\r\n"
					+ "									</div>\r\n"
					+ "								</div>\r\n"
					+ "								<a href=\"/OnlineEntertaiment/detail?id="+o.getId()+"\"><small\r\n"
					+ "									class=\"text-light py-1\">"+o.getTitle()+"</small></a>\r\n"
					+ "							</div>");
		}
	}

}
