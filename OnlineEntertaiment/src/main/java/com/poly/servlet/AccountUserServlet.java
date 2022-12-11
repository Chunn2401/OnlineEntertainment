package com.poly.servlet;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.RandomStringUtils;
import com.poly.dao.UserDao;
import com.poly.model.User;
import com.poly.utils.SessionUtils;

@WebServlet({ "/account/sign-in", "/account/sign-up", "/account/sign-out", "/account/forgot-password",
		"/account/change-password", "/account/edit-profile", "/account/loginfb.php" })
public class AccountUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("sign-in")) {
			this.doSignIn(request, response);
		} else if (uri.contains("sign-up")) {
			this.doSignUp(request, response);
		} else if (uri.contains("sign-out")) {
			this.doSignOut(request, response);
		} else if (uri.contains("forgot-password")) {
			this.doForgotPassword(request, response);
		} else if (uri.contains("change-password")) {
			this.doChangePassword(request, response);
		} else if (uri.contains("edit-profile")) {
			this.doEditProfile(request, response);
		} else if (uri.contains("loginfb.php")) {
			this.doLoginFB(request, response);
		}

	}

	private void doSignIn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			// TODO: Login method post
			String username = request.getParameter("username");
			String pw = request.getParameter("password");
			try {
				UserDao dao = new UserDao();
				User user = dao.findById(username);
				if (!user.getPassword().equals(pw)) {
					request.setAttribute("message", "Wrong password!");
					request.getRequestDispatcher("/views/user/account/sign-in.jsp").forward(request, response);
				} else {
//					doFindAllVideo(request, response);
					SessionUtils.add(request, "username", username);
					SessionUtils.add(request, "user", user);
					response.sendRedirect("/OnlineEntertaiment/Homepage");
				}
			} catch (Exception e) {
				request.setAttribute("message", "Wrong username!");
				request.getRequestDispatcher("/views/user/account/sign-in.jsp").forward(request, response);
			}
		} else {
			User user = (User) SessionUtils.get(request, "user");
			if (user != null) {
//				doFindAllVideo(request, response);
				request.getRequestDispatcher("/Homepage").forward(request, response);
			} else {
				request.getRequestDispatcher("/views/user/account/sign-in.jsp").forward(request, response);
			}
		}

	}

	private void doSignUp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			// TODO: SignUp doPost
			String username = request.getParameter("username");
			try {
				User user = new User();
				BeanUtils.populate(user, request.getParameterMap());
				UserDao dao = new UserDao();
				dao.insert(user);
				SessionUtils.add(request, "username", username);
				SessionUtils.add(request, "user", user);
				request.getRequestDispatcher("/Homepage").forward(request, response);
			} catch (Exception e) {
				request.setAttribute("message", "Registration error!");
				request.getRequestDispatcher("/views/user/account/sign-up.jsp").forward(request, response);
			}
		} else {
			// TODO: SignUp doGet
			User user = (User) SessionUtils.get(request, "user");
			if (user != null) {
				request.getRequestDispatcher("/Homepage").forward(request, response);
			} else {
				request.getRequestDispatcher("/views/user/account/sign-up.jsp").forward(request, response);
			}
		}
	}

	private void doSignOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionUtils.invalidate(request);
		try {
			request.getRequestDispatcher("/views/user/account/sign-in.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void doEditProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) SessionUtils.get(request, "user");
		String method = request.getMethod();

		if (method.equalsIgnoreCase("POST")) {
			// TODO: EditProfile
			try {
				BeanUtils.populate(user, request.getParameterMap());
				UserDao dao = new UserDao();
				user.setId(user.getId());
				dao.update(user);
				request.setAttribute("message", "Update account done!");
			} catch (Exception e) {
				request.setAttribute("message", "Update account fail!");
			}
			request.setAttribute("user", user);
			request.getRequestDispatcher("/views/user/account/edit-profile.jsp").forward(request, response);
		} else {
			request.setAttribute("user", user);
			try {
				request.getRequestDispatcher("/views/user/account/edit-profile.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	private void doChangePassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) SessionUtils.get(request, "user");
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			try {
				String password = request.getParameter("password");
				String password_new = request.getParameter("password_new");
				String re_password_new = request.getParameter("re_password_new");
				UserDao dao = new UserDao();
				if (!user.getPassword().equals(password)) {
					request.setAttribute("message", "Incorrect password!");
				} else {
					if (!re_password_new.equals(password_new)) {
						request.setAttribute("message", "Repeat incorrect password!");
					} else {
						user.setId(user.getId());
						user.setPassword(password_new);
						dao.update(user);
						request.setAttribute("message", "Change password done!");
					}
				}
			} catch (Exception e) {
				request.setAttribute("message", "Change password fail!");
			}
		} else {
			try {
				request.getRequestDispatcher("/views/user/account/change-password.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	private void doForgotPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) SessionUtils.get(request, "user");
		String method = request.getMethod();
		if (user != null) {
			request.getRequestDispatcher("/Homepage").forward(request, response);
		} else {
			if (method.equalsIgnoreCase("POST")) {
				try {
					String username = request.getParameter("username");
					UserDao dao = new UserDao();
					user = dao.findById(username);
					if (user == null) {
						request.setAttribute("message", "Account name does not exist!");
					} else {
						// Thong so ket noi SMTP Server
						Properties p = new Properties();
						p.put("mail.smtp.auth", "true");
						p.put("mail.smtp.starttls.enable", "true");
						p.put("mail.smtp.host", "smtp.gmail.com");
						p.put("mail.smtp.port", "587");

						String emailfrom = "dongtrieuit@gmail.com";
						String password = "opreiycsjwoencrv";

						Session s = Session.getInstance(p, new javax.mail.Authenticator() {
							protected PasswordAuthentication getPasswordAuthentication() {

								return new PasswordAuthentication(emailfrom, password);
							}
						});

						String from = emailfrom;
						String to = user.getEmail();
						String subject = "Forgot password Online Entertainment";
						String body = "Your password is: " + user.getPassword();

						Message msg = new MimeMessage(s);
						msg.setFrom(new InternetAddress(from));
						msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
						msg.setSubject(subject);
						msg.setText(body);

						Transport.send(msg);

						request.setAttribute("message", "Forgot password done!");
					}

				} catch (Exception ex) {
					request.setAttribute("message", "Forgot password fail!");
					System.out.print("Error:" + ex);
				}
				request.getRequestDispatcher("/views/user/account/forgot-password.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/views/user/account/forgot-password.jsp").forward(request, response);
			}
		}
	}

	private void doLoginFB(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			// Lấy dữ liệu các trường
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			// Kiểm tra id đã tồn tại chưa, nếu tồn tại thì login, nếu chưa thì đăng ký +
			// login
			UserDao userDao = new UserDao();
			if (userDao.findById(id) != null) {
				// todo: login
				System.out.println("login fb");
				User user = userDao.findById(id);
				SessionUtils.add(request, "username", id);
				SessionUtils.add(request, "user", user);
				request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
			} else {
				// todo: reg
				System.out.println("reg fb");
				String password = RandomStringUtils.randomAlphanumeric(10);
				User user = new User();
				user.setId(id);
				user.setPassword(password);
				user.setFullname(name);
				user.setEmail(email);
				user.setAdmin(false);
				UserDao dao = new UserDao();
				dao.insert(user);
				SessionUtils.add(request, "username", id);
				SessionUtils.add(request, "user", user);
				request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
			}
		} else {
			// nếu vào get thì gửi về cái lỗi cho nó
			response.setStatus(400);
			request.setAttribute("message", "Login with facebook fail!");
			request.getRequestDispatcher("/views/user/account/sign-up.jsp").forward(request, response);
		}

	}
}
