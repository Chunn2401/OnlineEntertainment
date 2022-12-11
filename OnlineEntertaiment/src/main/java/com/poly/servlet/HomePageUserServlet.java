package com.poly.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.common.PageInfo;
import com.poly.common.PageType;
import com.poly.dao.ReportDao;
import com.poly.dao.VideoDao;
import com.poly.model.Report;
import com.poly.model.Video;

@WebServlet("/Homepage")
public class HomePageUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VideoDao dao = new VideoDao();
		ReportDao reportDao = new ReportDao();
		List<Video> videoFavoriteTop1To4 = new ArrayList<Video>();
		List<Video> videoFavoriteTop5To8 = new ArrayList<Video>();
		
		for (Report report : reportDao.getTopLike(false, 0, 4)) {
			Video video = dao.findById(report.getGroup());
			videoFavoriteTop1To4.add(video);
		}
		for (Report report : reportDao.getTopLike(false, 4, 4)) {
			Video video = dao.findById(report.getGroup());
			videoFavoriteTop5To8.add(video);
		}

		List<Video> videoViewsTop1To4 = dao.getTopViews(false, 0, 4);
		List<Video> videoViewsTop5To8 = dao.getTopViews(false, 4, 4);
		List<Video> showAll = dao.findAll();
		
		
	
		
		request.setAttribute("favorite_slide1", videoFavoriteTop1To4); 
		request.setAttribute("favorite_slide2", videoFavoriteTop5To8); 
		request.setAttribute("view_slide1", videoViewsTop1To4);
		request.setAttribute("view_slide2", videoViewsTop5To8); 
		request.setAttribute("showAll", showAll); 
		

		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}

}
