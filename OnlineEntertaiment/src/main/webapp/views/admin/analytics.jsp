<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard: Manager Users</title>
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.css"
	rel="stylesheet" />
<!-- Custom styles -->
<link rel="stylesheet"
	href="<c:url value = "/templates/admin/css/style.css"/>" />
</head>
<body>
	<!--Main Navigation-->
	<header>
		<!-- Sidebar -->
		<%@include file="/views/admin/layout/sidebar.jsp"%>
		<!-- Sidebar -->

		<!-- Navbar -->
		<%@include file="/views/admin/layout/menu.jsp"%>
		<!-- Navbar -->
	</header>
	<!--Main Navigation-->
	<!--Main layout-->
	<main style="margin-top: 58px">
		<div class="container pt-4">
			<section class="mb-4">

				<c:if test="${not empty message}">
					<div class="alert alert-success" role="alert">${message}</div>
				</c:if>
				<c:if test="${not empty error}">
					<div class="alert alert-danger" role="alert">${error}</div>
				</c:if>

				<div class="accordion" id="accordionExample">
					<div class="accordion-item">
						<h2 class="accordion-header" id="headingOne">
							<button class="accordion-button" type="button"
								data-mdb-toggle="collapse" data-mdb-target="#collapseOne"
								aria-expanded="true" aria-controls="collapseOne">Tìm
								các video yêu thích theo người sử dụng (nhập user id)</button>
						</h2>
						<div id="collapseOne" class="accordion-collapse collapse"
							aria-labelledby="headingOne" data-mdb-parent="#accordionExample">
							<div class="accordion-body">
								<!--Section: Sales Performance KPIs-->
								<section class="mb-4">
									<div class="container">

										<form action="<c:url value = "/dashboard/analytics/find-video-user"/>"
											method="post">
											<!-- PASSWORD input -->
											<div class="form-outline mb-4">
												<input type="text" id="username" name="username"
													class="form-control" value="" /> <label class="form-label"
													for="username">Username</label>
											</div>

											<!-- Submit button -->
											<button class="btn btn-secondary" type="submit">Submit</button>
										</form>
									</div>
									<br>
									<c:if test="${not empty user}">
										<div class="alert alert-success" role="alert">
											<p>
												<c:out value="${user.fullname}" />
											</p>
											<p>
												<c:out value="${user.email}" />
											</p>
										</div>
									</c:if>

									<c:if test="${not empty favorites}">
										<table class="table">
											<thead>
												<tr>
													<th scope="col">ID</th>
													<th scope="col">TITLE</th>
													<th scope="col">VIEWS</th>
													<th scope="col">ACTIVE</th>
												</tr>
											</thead>

											<c:forEach var="item" items="${favorites}">
												<tbody>
													<tr>
														<th><c:out value="${item.id}" /></th>
														<th><c:out value="${item.video.title}" /></th>
														<th><c:out value="${item.video.views}" /></th>
														<th><c:out value="${item.video.active}" /></th>
													</tr>
												</tbody>
											</c:forEach>
										</table>
									</c:if>
								</section>
								<!--Section: Sales Performance KPIs-->
							</div>
						</div>
					</div>

					<div class="accordion-item">
						<h2 class="accordion-header" id="headingTwo">
							<button class="accordion-button collapsed" type="button"
								data-mdb-toggle="collapse" data-mdb-target="#collapseTwo"
								aria-expanded="false" aria-controls="collapseTwo">Tìm
								các video được yêu thích có title chứa từ khóa (nhập từ khóa)</button>
						</h2>
						<div id="collapseTwo" class="accordion-collapse collapse"
							aria-labelledby="headingTwo" data-mdb-parent="#accordionExample">
							<div class="accordion-body">
								<section class="mb-4">
									<div class="container">

										<form action="<c:url value = "/dashboard/analytics/find-video-title"/>"
											method="post">
											<div class="form-outline mb-4">
												<input type="text" id="keyword" name="keyword"
													class="form-control" value="" /> <label class="form-label"
													for="keyword">Keyword</label>
											</div>

											<!-- Submit button -->
											<button class="btn btn-secondary" type="submit">Submit</button>
										</form>
									</div>
									<br>

									<c:if test="${not empty videos}">
										<table class="table">
											<thead>
												<tr>
													<th scope="col">ID</th>
													<th scope="col">TITLE</th>
													<th scope="col">VIEWS</th>
													<th scope="col">ACTIVE</th>
												</tr>
											</thead>

											<c:forEach var="item" items="${videos}">
												<tbody>
													<tr>
														<th><c:out value="${item.id}" /></th>
														<th><c:out value="${item.title}" /></th>
														<th><c:out value="${item.views}" /></th>
														<th><c:out value="${item.active}" /></th>
													</tr>
												</tbody>
											</c:forEach>
										</table>
									</c:if>
								</section>
								<!--Section: Sales Performance KPIs-->

							</div>
						</div>
					</div>

					<div class="accordion-item">
						<h2 class="accordion-header" id="headingThree">
							<button class="accordion-button collapsed" type="button"
								data-mdb-toggle="collapse" data-mdb-target="#collapseThree"
								aria-expanded="false" aria-controls="collapseThree">Tìm
								những người sử dụng thích video (nhập video id)</button>
						</h2>
						<div id="collapseThree" class="accordion-collapse collapse"
							aria-labelledby="headingThree"
							data-mdb-parent="#accordionExample">
							<div class="accordion-body">
								<!--Section: Sales Performance KPIs-->
								<section class="mb-4">
									<div class="container">
										<form action="<c:url value = "/dashboard/analytics/find-user-like"/>"
											method="post">
											<!-- PASSWORD input -->
											<div class="form-outline mb-4">
												<input type="text" id="videoId" name="videoId"
													class="form-control" value="" /> <label class="form-label"
													for="videoId">Video Id</label>
											</div>

											<!-- Submit button -->
											<button class="btn btn-secondary" type="submit">Submit</button>
										</form>
									</div>
									<br>

									<c:if test="${not empty user_like}">
										<table class="table">
											<thead>
												<tr>
													<th scope="col">ID</th>
													<th scope="col">FULLNAME</th>
													<th scope="col">EMAIL</th>
													<th scope="col">ADMIN</th>
												</tr>
											</thead>

											<c:forEach var="item" items="${user_like}">
												<tbody>
													<tr>
														<th><c:out value="${item.id}" /></th>
														<th><c:out value="${item.fullname}" /></th>
														<th><c:out value="${item.email}" /></th>
														<th><c:out value="${item.admin}" /></th>
													</tr>
												</tbody>
											</c:forEach>
										</table>
									</c:if>
								</section>
								<!--Section: Sales Performance KPIs-->
							</div>
						</div>
					</div>

					<div class="accordion-item">
						<h2 class="accordion-header" id="headingFour">
							<button class="accordion-button collapsed" type="button"
								data-mdb-toggle="collapse" data-mdb-target="#collapseFour"
								aria-expanded="false" aria-controls="collapseFour">Hiển
								thị tất cả các video không có hoặc có yêu thích</button>
						</h2>
						<div id="collapseFour" class="accordion-collapse collapse"
							aria-labelledby="headingFour" data-mdb-parent="#accordionExample">
							<div class="accordion-body">
								<!--Section: Sales Performance KPIs-->
								<section class="mb-4">
									<div class="container">
										<form action="<c:url value = "/dashboard/analytics/show-video-status"/>"
											method="post">
											<div class="btn-group">
												<input type="radio" class="btn-check" name="favorite"
													id="favorite1" autocomplete="off" checked /> <label
													class="btn btn-secondary" for="favorite1">Favorite</label>

												<input type="radio" class="btn-check" name="favorite"
													id="favorite2" autocomplete="off" /> <label
													class="btn btn-secondary" for="favorite2">Not
													Favorite</label>
											</div>

											<button class="btn btn-secondary" type="submit">Submit</button>
										</form>
									</div>
									<br>
									<c:if test="${not empty video_actions}">
										<table class="table">
											<thead>
												<tr>
													<th scope="col">ID</th>
													<th scope="col">TITLE</th>
													<th scope="col">VIEWS</th>
													<th scope="col">ACTIVE</th>
												</tr>
											</thead>

											<c:forEach var="item" items="${video_actions}">
												<tbody>
													<tr>
														<th><c:out value="${item.id}" /></th>
														<th><c:out value="${item.title}" /></th>
														<th><c:out value="${item.views}" /></th>
														<th><c:out value="${item.active}" /></th>
													</tr>
												</tbody>
											</c:forEach>
										</table>
									</c:if>
								</section>
							</div>
						</div>
					</div>

					<div class="accordion-item">
						<h2 class="accordion-header" id="headingFive">
							<button class="accordion-button collapsed" type="button"
								data-mdb-toggle="collapse" data-mdb-target="#collapseFive"
								aria-expanded="false" aria-controls="collapseFive">Tổng
								hợp số lượt thích từng video theo cấu trúc</button>
						</h2>
						<div id="collapseFive" class="accordion-collapse collapse"
							aria-labelledby="headingFive" data-mdb-parent="#accordionExample">
							<div class="accordion-body">
								<section class="mb-4">
									<div class="alert alert-danger" role="alert">
										<a href="<c:url value = "/dashboard/analytics/show-report-all"/>">Click
											to continue!</a>
									</div>

									<c:if test="${not empty report_all}">
										<table class="table">
											<thead>
												<tr>
													<th scope="col">GROUP</th>
													<th scope="col">LIKE</th>
													<th scope="col">NEWEST</th>
													<th scope="col">OLDEST</th>
												</tr>
											</thead>

											<c:forEach var="item" items="${report_all}">
												<tbody>
													<tr>
														<th><c:out value="${item.group}" /></th>
														<th><c:out value="${item.likes}" /></th>
														<th><c:out value="${item.newest}" /></th>
														<th><c:out value="${item.oldest}" /></th>
													</tr>
												</tbody>
											</c:forEach>
										</table>
									</c:if>
								</section>
							</div>
						</div>
					</div>

					<div class="accordion-item">
						<h2 class="accordion-header" id="headingSix">
							<button class="accordion-button collapsed" type="button"
								data-mdb-toggle="collapse" data-mdb-target="#collapseSix"
								aria-expanded="false" aria-controls="collapseSix">Tìm
								các video được yêu thích có title chứa từ khóa (nhập từ khóa)</button>
						</h2>
						<div id="collapseSix" class="accordion-collapse collapse"
							aria-labelledby="headingSix" data-mdb-parent="#accordionExample">
							<div class="accordion-body">
								<section class="mb-4">
									<div class="container">
										<form
											action="<c:url value = "/dashboard/analytics/find-videolike-title"/>"
											method="post">
											<!-- PASSWORD input -->
											<div class="form-outline mb-4">
												<input type="text" id="keyword_title" name="keyword_title"
													class="form-control" value="" /> <label class="form-label"
													for="keyword_title">Keyword title</label>
											</div>

											<button class="btn btn-secondary" type="submit">Submit</button>
										</form>
									</div>
									<br>

									<c:if test="${not empty video_like_title}">
										<table class="table">
											<thead>
												<tr>
													<th scope="col">ID</th>
													<th scope="col">TITLE</th>
													<th scope="col">VIEWS</th>
													<th scope="col">ACTIVE</th>
												</tr>
											</thead>

											<c:forEach var="item" items="${video_like_title}">
												<tbody>
													<tr>
														<th><c:out value="${item.id}" /></th>
														<th><c:out value="${item.title}" /></th>
														<th><c:out value="${item.views}" /></th>
														<th><c:out value="${item.active}" /></th>
													</tr>
												</tbody>
											</c:forEach>
										</table>
									</c:if>
								</section>
							</div>
						</div>
					</div>

					<div class="accordion-item">
						<h2 class="accordion-header" id="headingSeven">
							<button class="accordion-button collapsed" type="button"
								data-mdb-toggle="collapse" data-mdb-target="#collapseSeven"
								aria-expanded="false" aria-controls="collapseSeven">Tìm
								các video yêu thích theo người sử dụng (nhập user id)</button>
						</h2>
						<div id="collapseSeven" class="accordion-collapse collapse"
							aria-labelledby="headingSeven"
							data-mdb-parent="#accordionExample">
							<div class="accordion-body">
								<section class="mb-4">
									<div class="container">
										<form
											action="<c:url value = "/dashboard/analytics/find-videolike-user"/>"
											method="post">
											<div class="form-outline mb-4">
												<input type="text" id="usernamelike" name="usernamelike"
													class="form-control" value="" /> <label class="form-label"
													for="usernamelike">Username</label>
											</div>

											<button class="btn btn-secondary" type="submit">Submit</button>
										</form>
									</div>
									<br>

									<c:if test="${not empty video_like_user}">
										<table class="table">
											<thead>
												<tr>
													<th scope="col">ID</th>
													<th scope="col">TITLE</th>
													<th scope="col">VIEWS</th>
													<th scope="col">ACTIVE</th>
												</tr>
											</thead>

											<c:forEach var="item" items="${video_like_user}">
												<tbody>
													<tr>
														<th><c:out value="${item.id}" /></th>
														<th><c:out value="${item.title}" /></th>
														<th><c:out value="${item.views}" /></th>
														<th><c:out value="${item.active}" /></th>
													</tr>
												</tbody>
											</c:forEach>
										</table>
									</c:if>
								</section>
							</div>
						</div>
					</div>

					<div class="accordion-item">
						<h2 class="accordion-header" id="headingEight">
							<button class="accordion-button collapsed" type="button"
								data-mdb-toggle="collapse" data-mdb-target="#collapseEight"
								aria-expanded="false" aria-controls="collapseEight">Tìm
								những video được thích trong khoảng thời gian</button>
						</h2>
						<div id="collapseEight" class="accordion-collapse collapse"
							aria-labelledby="headingEight"
							data-mdb-parent="#accordionExample">
							<div class="accordion-body">
								<section class="mb-4">
									<div class="container">
										<form
											action="<c:url value = "/dashboard/analytics/find-videolike-date"/>"
											method="post">
											<div class="form-outline mb-4">
												<input class="form-control datepicker" name="fromDate"
													type="date" /> <label class="form-label">From date?</label>
											</div>

											<div class="form-outline mb-4">
												<input class="form-control datepicker" name="toDate"
													type="date" /> <label class="form-label">To date?</label>
											</div>

											<!-- Submit button -->
											<button class="btn btn-secondary" type="submit">Submit</button>
										</form>
									</div>
									<br>

									<c:if test="${not empty video_like_date}">
										<table class="table">
											<thead>
												<tr>
													<th scope="col">ID</th>
													<th scope="col">TITLE</th>
													<th scope="col">VIEWS</th>
													<th scope="col">ACTIVE</th>
												</tr>
											</thead>

											<c:forEach var="item" items="${video_like_date}">
												<tbody>
													<tr>
														<th><c:out value="${item.id}" /></th>
														<th><c:out value="${item.title}" /></th>
														<th><c:out value="${item.views}" /></th>
														<th><c:out value="${item.active}" /></th>
													</tr>
												</tbody>
											</c:forEach>
										</table>
									</c:if>
								</section>
							</div>
						</div>
					</div>

					<div class="accordion-item">
						<h2 class="accordion-header" id="headingNine">
							<button class="accordion-button collapsed" type="button"
								data-mdb-toggle="collapse" data-mdb-target="#collapseNine"
								aria-expanded="false" aria-controls="collapseNine">Tìm
								những video được thích trong trong các tháng</button>
						</h2>
						<div id="collapseNine" class="accordion-collapse collapse"
							aria-labelledby="headingNine" data-mdb-parent="#accordionExample">
							<div class="accordion-body">
								<section class="mb-4">
									<div class="container">
										<form
											action="<c:url value = "/dashboard/analytics/find-videolike-month"/>"
											method="post">
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox1" value="1" name="month" /> <label
													class="form-check-label" for="inlineCheckbox1">1</label>
											</div>

											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox2" value="2" name="month" /> <label
													class="form-check-label" for="inlineCheckbox2">2</label>
											</div>

											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox3" value="3" name="month" /> <label
													class="form-check-label" for="inlineCheckbox3">3 </label>
											</div>

											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox4" value="4" name="month" /> <label
													class="form-check-label" for="inlineCheckbox4">4 </label>
											</div>

											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox5" value="5" name="month" /> <label
													class="form-check-label" for="inlineCheckbox5">5 </label>
											</div>


											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox6" value="6" name="month" /> <label
													class="form-check-label" for="inlineCheckbox6">6 </label>
											</div>

											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox7" value="7" name="month" /> <label
													class="form-check-label" for="inlineCheckbox7">7 </label>
											</div>

											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox8" value="8" name="month" /> <label
													class="form-check-label" for="inlineCheckbox8">8 </label>
											</div>

											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox9" value="9" name="month" /> <label
													class="form-check-label" for="inlineCheckbox9">9 </label>
											</div>

											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox10" value="10" name="month" /> <label
													class="form-check-label" for="inlineCheckbox10">10
												</label>
											</div>

											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox11" value="11" name="month" /> <label
													class="form-check-label" for="inlineCheckbox11">11
												</label>
											</div>

											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox12" value="12" name="month" /> <label
													class="form-check-label" for="inlineCheckbox12">12
												</label>
											</div>

											<button class="btn btn-secondary" type="submit">Submit</button>
										</form>
									</div>
									<br>

									<c:if test="${not empty video_like_month}">
										<table class="table">
											<thead>
												<tr>
													<th scope="col">ID</th>
													<th scope="col">TITLE</th>
													<th scope="col">VIEWS</th>
													<th scope="col">ACTIVE</th>
												</tr>
											</thead>

											<c:forEach var="item" items="${video_like_month}">
												<tbody>
													<tr>
														<th><c:out value="${item.id}" /></th>
														<th><c:out value="${item.title}" /></th>
														<th><c:out value="${item.views}" /></th>
														<th><c:out value="${item.active}" /></th>
													</tr>
												</tbody>
											</c:forEach>
										</table>
									</c:if>
								</section>
							</div>
						</div>
					</div>

					<div class="accordion-item">
						<h2 class="accordion-header" id="headingTen">
							<button class="accordion-button collapsed" type="button"
								data-mdb-toggle="collapse" data-mdb-target="#collapseTen"
								aria-expanded="false" aria-controls="collapseTen">Truy
								vấn và hiển thị 10 video ngẫu nhiên</button>
						</h2>
						<div id="collapseTen" class="accordion-collapse collapse"
							aria-labelledby="headingTen" data-mdb-parent="#accordionExample">
							<div class="accordion-body">
								<section class="mb-4">
									<div class="alert alert-danger" role="alert">
										<a href="<c:url value = "/dashboard/analytics/show-random10-video"/>">Click
											to continue!</a>
									</div>

									<c:if test="${not empty video_top10}">
										<table class="table">
											<thead>
												<tr>
													<th scope="col">ID</th>
													<th scope="col">TITLE</th>
													<th scope="col">VIEWS</th>
													<th scope="col">ACTIVE</th>
												</tr>
											</thead>

											<c:forEach var="item" items="${video_top10}">
												<tbody>
													<tr>
														<th><c:out value="${item.id}" /></th>
														<th><c:out value="${item.title}" /></th>
														<th><c:out value="${item.views}" /></th>
														<th><c:out value="${item.active}" /></th>
													</tr>
												</tbody>
											</c:forEach>
										</table>
									</c:if>
								</section>
							</div>
						</div>
					</div>
					<div class="accordion-item">
						<h2 class="accordion-header" id="headingEleven">
							<button class="accordion-button collapsed" type="button"
								data-mdb-toggle="collapse" data-mdb-target="#collapseEleven"
								aria-expanded="false" aria-controls="collapseEleven">Tổng
								hợp số lượt thích từng video theo năm có cấu trúc</button>
						</h2>
						<div id="collapseEleven" class="accordion-collapse collapse"
							aria-labelledby="headingEleven"
							data-mdb-parent="#accordionExample">
							<div class="accordion-body">
								<section class="mb-4">
									<div class="alert alert-danger" role="alert">
										<a href="<c:url value = "/dashboard/analytics/show-report-year"/>">Click
											to continue!</a>
									</div>
									<div class="container">
										<form action="<c:url value = "/dashboard/analytics/show-report-year"/>"
											method="post">
											<div class="mb-4">
												<select name="year">
													<c:forEach var="opt" items="${sel}">
														<option value="${opt}">${opt}</option>
													</c:forEach>
												</select>
											</div>

											<button class="btn btn-secondary" type="submit">Submit</button>
										</form>
									</div>
									<br>

									<c:if test="${not empty item}">
										<table class="table">
											<thead>
												<tr>
													<th scope="col">TITLE</th>
													<th scope="col">FAVORITE COUNT</th>
													<th scope="col">NEWEST DATE</th>
													<th scope="col">OLDEST DATE</th>
												</tr>
											</thead>

											<c:forEach var="item" items="${item}">
												<tbody>
													<tr>
														<th><c:out value="${item.Group}" /></th>
														<th><c:out value="${item.Likes}" /></th>
														<th><c:out value="${item.Newest}" /></th>
														<th><c:out value="${item.Oldest}" /></th>
													</tr>
												</tbody>
											</c:forEach>
										</table>
									</c:if>
								</section>
							</div>
						</div>
					</div>
					
				</div>
			</section>
		</div>


	</main>
	<!--Main layout-->
</body>
<!-- MDB -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.js"></script>
<!-- Custom scripts -->
</html>