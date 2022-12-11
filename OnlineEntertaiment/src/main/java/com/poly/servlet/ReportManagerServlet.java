package com.poly.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.UserDao;
import com.poly.model.Favorite;
import com.poly.model.User;
import com.poly.model.Video;
import com.poly.utils.JpaUtils;
import com.poly.dao.ReportDao;

import com.poly.dao.VideoDao;



@WebServlet({"/dashboard/analytics",
			"/dashboard/analytics/find-video-user",
			"/dashboard/analytics/find-video-title",
			"/dashboard/analytics/find-user-like",
			"/dashboard/analytics/show-video-status",
			"/dashboard/analytics/show-report-all",
			"/dashboard/analytics/find-videolike-title",
			"/dashboard/analytics/find-videolike-user",
			"/dashboard/analytics/find-videolike-date",
			"/dashboard/analytics/find-videolike-month",
			"/dashboard/analytics/show-random10-video",
			"/dashboard/analytics/show-report-year"})

public class ReportManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("find-video-user")) {
			try {
				this.doFindVideo(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (uri.contains("find-video-title")) {
			try {
				this.doFindVideoTitle(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (uri.contains("find-user-like")) {
			try {
				this.doFindUserLike(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (uri.contains("show-video-status")) {
			try {
				this.doShowVideoStatus(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (uri.contains("show-report-all")) {
			try {
				this.doShowReportAll(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (uri.contains("find-videolike-title")) {
			try {
				this.doFindVideoLikeForTitle(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (uri.contains("find-videolike-user")) {
			try {
				this.doFindVideoLikeForUser(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (uri.contains("find-videolike-date")) {
			try {
				this.doFindVideoLikeForDate(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (uri.contains("find-videolike-month")) {
			try {
				this.doFindVideoLikeForMonth(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (uri.contains("show-random10-video")) {
			try {
				this.doShowRd10Video(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (uri.contains("show-report-year")) {
			try {
				this.doShowReportYear(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			this.doHome(request, response);
		}
	}
	
	
	private void doHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.getRequestDispatcher("/views/admin/analytics.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	
	private void doFindVideo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			String username = request.getParameter("username");
			UserDao dao = new UserDao(); 
			User user = dao.findById(username);
			List<Favorite> favorites = user.getFavorites();
			request.setAttribute("user", user);
			request.setAttribute("favorites", favorites);
			request.getRequestDispatcher("/views/admin/analytics.jsp").forward(request, response);
		}else {
			User user = new User();
			user = null;
			request.getRequestDispatcher("/dashboard").forward(request, response);
		}
	}
	
	private void doFindVideoTitle(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			String keyword = request.getParameter("keyword");
			VideoDao daoVideo = new VideoDao();
			request.setAttribute("videos", daoVideo.findByKeyWord(keyword));
			request.getRequestDispatcher("/views/admin/analytics.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/dashboard").forward(request, response);
		}
	}
	
	private void doFindUserLike(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			
			String videoId = request.getParameter("videoId");
			UserDao dao = new UserDao();
			request.setAttribute("user_like", dao.findUserLikeVideo(videoId));
			request.getRequestDispatcher("/views/admin/analytics.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("/dashboard").forward(request, response);
		}
	}
	
	private void doShowVideoStatus(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			
			VideoDao dao = new VideoDao();
			boolean favorite = Boolean.parseBoolean(request.getParameter("favorite"));
			request.setAttribute("video_actions", dao.showVideo(favorite));
			request.getRequestDispatcher("/views/admin/analytics.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("/views/dashboard.jsp").forward(request, response);
		}
	}
	
	private void doShowReportAll(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("GET")) {
			ReportDao reportDao = new ReportDao();
			request.setAttribute("report_all", reportDao.getInfor());
			request.getRequestDispatcher("/views/admin/analytics.jsp").forward(request, response);
			
		}
	}
	
	private void doFindVideoLikeForTitle(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			VideoDao dao = new VideoDao();
			String keyword = request.getParameter("keyword_title");
			request.setAttribute("video_like_title", dao.findByKeywordNameQR(keyword));
			request.getRequestDispatcher("/views/admin/analytics.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("/dashboard").forward(request, response);
		}
	}
	
	private void doFindVideoLikeForUser(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			VideoDao daoVideo = new VideoDao();
			String id = request.getParameter("usernamelike");
			request.setAttribute("video_like_user", daoVideo.findByUserNameQR(id));
			request.getRequestDispatcher("/views/admin/analytics.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("/dashboard").forward(request, response);
		}
	}
	
	private void doFindVideoLikeForDate(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			VideoDao daoVideo = new VideoDao();
			String from = request.getParameter("fromDate");
			String to = request.getParameter("toDate");
			Date fromD = new SimpleDateFormat("yyyy-MM-dd").parse(from);
			Date toD = new SimpleDateFormat("yyyy-MM-dd").parse(to);
			request.setAttribute("video_like_date", daoVideo.findInRangeNameQR(fromD, toD));
			request.getRequestDispatcher("/views/admin/analytics.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("/dashboard").forward(request, response);
		}
	}
	
	private void doFindVideoLikeForMonth(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			VideoDao daoVideo = new VideoDao();
			List<Integer> months = new ArrayList<Integer>();
			String[] values = request.getParameterValues("month");
			for(String month:values) {
				months.add(Integer.parseInt(month));
			}
			request.setAttribute("video_like_month", daoVideo.findInMonthsNameQR(months));
			request.getRequestDispatcher("/views/admin/analytics.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("/dashboard").forward(request, response);
		}
	}
	
	private void doShowRd10Video(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("GET")) {
			VideoDao daoVideo = new VideoDao();
			request.setAttribute("video_top10", daoVideo.getRandom10());
			request.getRequestDispatcher("/views/admin/analytics.jsp").forward(request, response);
			
		} 
	}
	
	private void doShowReportYear(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("GET")) {
			ReportDao reportDao = new ReportDao();
			request.setAttribute("sel", reportDao.selectYear());
			request.getRequestDispatcher("/views/admin/analytics.jsp").forward(request, response);
		} else {
			EntityManager em = JpaUtils.getEntityManager();
			Integer year = Integer .valueOf(request.getParameter("year"));
			StoredProcedureQuery query = em.createStoredProcedureQuery("Report.favoriteByYear");
			query.setParameter("year", year);
			List<Video> list = query.getResultList();
			
			request.setAttribute("item", list);
			request.getRequestDispatcher("/views/admin/analytics.jsp").forward(request, response);
		}
	}


}
