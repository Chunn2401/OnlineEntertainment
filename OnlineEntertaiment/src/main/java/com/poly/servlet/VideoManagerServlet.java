package com.poly.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.VideoDao;
import com.poly.model.User;
import com.poly.model.Video;
import com.poly.utils.SessionUtils;
import com.poly.utils.UploadUltils;

@WebServlet({ "/dashboard/video", "/dashboard/video/create", "/dashboard/video/update", "/dashboard/video/delete",
		"/dashboard/video/edit", "/dashboard/video/reset" })
@MultipartConfig
public class VideoManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) SessionUtils.get(request, "user");
		Video video = new Video();
		Video video_one = new Video();

		try {
			String url = request.getRequestURL().toString();
			if (url.contains("delete")) {
				delete(request, response);
				video = new Video();
				request.setAttribute("video", video);
			} else if (url.contains("edit")) {
				edit(request, response);
			} else if (url.contains("reset")) {
				video = new Video();
				request.setAttribute("video", video);
			} else {
				VideoDao dao = new VideoDao();
				video_one = new Video("", "", "", "", "", true);
				request.setAttribute("video_one", video_one);
			}

			findAll(request, response);
			try {
				request.getRequestDispatcher("/views/admin/video.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/Homepage").forward(request, response);
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
			request.setAttribute("video", new Video());
		} else if (url.contains("reset")) {
			request.setAttribute("video", new Video());
		}
		findAll(request, response);
		try {
			request.getRequestDispatcher("/views/admin/video.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Video video = new Video();
			BeanUtils.populate(video, request.getParameterMap());
			VideoDao dao = new VideoDao();

			video.setPoster("" + UploadUltils.processUploadField("poster", request, "/uploads", video.getId()));

			dao.insert(video);
			request.setAttribute("message", "Video inserted!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Video video = new Video();
			BeanUtils.populate(video, request.getParameterMap());
			VideoDao dao = new VideoDao();
			Video oldVideo = dao.findById(video.getId());

			if (request.getPart("poster").getSize() == 0) {
				video.setPoster(oldVideo.getPoster());
			} else {
				video.setPoster(
						"" + UploadUltils.processUploadField("poster", request, "/uploads", video.getId()));
			}

			dao.update(video);
			request.setAttribute("video", video);
			request.setAttribute("message", "Video Updated!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			VideoDao dao = new VideoDao();
			dao.delete(id);
			request.setAttribute("message", "Video Deleted!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");

			VideoDao dao = new VideoDao();
			Video video = dao.findById(id);

			request.setAttribute("video_one", video);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			VideoDao dao = new VideoDao();

			List<Video> list = dao.findAll();

			request.setAttribute("video", list);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

}
