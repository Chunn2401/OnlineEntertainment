<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Entertainment</title>
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
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.1/mdb.min.css"
	rel="stylesheet" />
<script type="text/javascript" src="../js/style.js"></script>
<link rel="stylesheet" href="https://wowjs.uk/css/libs/animate.css">
<style type="text/css">
body {
	background-color: #111; 
	@media ( min-width : 480px) 
	{ #logo 
		{
		display: none;
	}
}
}

</style>
</head>
<body class="">
	<!-- Navbar -->
	<jsp:include page="/views/user/layout/menu.jsp"></jsp:include>

	<!-- Carousel image -->
	<jsp:include page="/views/user/layout/carousel.jsp"></jsp:include>
	
	
	<!-- Section: Video TOP 8 -->
	<section class="">
		<div class="container text-light my-5">
			<h4 class="text-uppercase black-text mx-3"><i class="fas fa-fire-alt"></i>  PHIM ĐƯỢC XEM NHIỀU NHẤT</h4>
			<!-- Carousel wrapper -->
			<div id="carouselFavorite"
				class="carousel slide carousel-dark text-center"
				data-mdb-ride="carousel">
				<!-- Controls -->
				<div class="d-flex justify-content-center mb-4 position-relative">
					<!-- Inner -->
					<div class="carousel-inner py-4">
						<!-- Single item -->
						<div class="carousel-item active" style="width: 100%;">
							<div class="container">
								<div class="row">
									<c:forEach var="video" items="${favorite_slide1 }">
										<!--Video col_3-->
										<div class="col-3 position-relative">
											<div class="bg-image hover-overlay ripple position-relative"
												data-mdb-ripple-color="light">
												<img src="<c:url value = "/uploads/"/>${video.poster }" class="col-12" />
										
												<div class="mask" style="background-color: rgba(251, 251, 251, 0.2)">
										
													<a href="<c:url value = "/detail?id=${video.id }"/>">
														<i class="far fa-play-circle fa-5x position-absolute top-50 start-50 translate-middle"></i>
													</a>
												
												</div>
												<div class="row">
													<div style="margin: 5px;" class="col-12  text-truncate position-absolute top-0 start-0 w-100"><c:out value="${video.title }" /></div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>

						<!-- Single item -->
						<div class="carousel-item">
							<div class="container">
								<div class="row">
									<c:forEach var="video" items="${favorite_slide2 }">
										<!--Video col_3-->
										<div class="col-3 position-relative">
											<div class="bg-image hover-overlay ripple position-relative"
												data-mdb-ripple-color="light">
												<img src="<c:url value = "/uploads/"/>${video.poster }" class="col-12" />
										
												<div class="mask" style="background-color: rgba(251, 251, 251, 0.2)">
										
													<a href="<c:url value = "/detail?id=${video.id }"/>">
														<i class="far fa-play-circle fa-5x position-absolute top-50 start-50 translate-middle"></i>
													</a>
												
												</div>
												<div class="row">
													<div style="margin: 5px;" class="col-12 text-truncate position-absolute top-0 start-0"><c:out value="${video.title }" /></div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
					<!-- Inner -->
					<button
						class="bg-dark carousel-control-prev position-absolute top-50 start-0 translate-middle"
						type="button" data-mdb-target="#carouselFavorite"
						data-mdb-slide="prev" style="width: 50px; height: 80%; margin-left: 25px;">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					</button>
					<button
						class="bg-dark carousel-control-next position-absolute top-50 start-100 translate-middle"
						type="button" data-mdb-target="#carouselFavorite"
						data-mdb-slide="next" style="width: 50px; height: 80%; margin-left: -25px;">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
					</button>
				</div>
			</div>
			<!-- Carousel wrapper -->
		</div>
	</section>
	<hr>
	<!-- Section: Video TOP 8 -->
	
	<!-- Section: Video TOP 8 -->
	<section class="">
		<div class="container text-light my-5">
			<h4 class="text-uppercase black-text mx-3"><i class="fas fa-fire-alt"></i>  PHIM ĐƯỢC YÊU THÍCH NHIỀU NHẤT</h4>
			<!-- Carousel wrapper -->
			<div id="carouselBasicExample"
				class="carousel slide carousel-dark text-center"
				data-mdb-ride="carousel">
				<!-- Controls -->
				<div class="d-flex justify-content-center mb-4 position-relative">
					<!-- Inner -->
					<div class="carousel-inner py-4">
						<!-- Single item -->
						<div class="carousel-item active">
							<div class="container">
								<div class="row span3 wow flipInX center">
									<c:forEach var="video" items="${view_slide1 }">
										<!--Video col_3-->
										<div class="col-6 col-md-3">
											<div class="bg-image hover-overlay ripple position-relative"
												data-mdb-ripple-color="light">
												<img src="<c:url value = "/uploads/"/>${video.poster }" class="img-fluid" />
										
										<div class="mask" style="background-color: rgba(251, 251, 251, 0.2)">
										
												<a href="<c:url value = "/detail?id=${video.id }"/>"><i
													class="far fa-play-circle fa-5x position-absolute top-50 start-50 translate-middle"></i></a>
												
											</div>
										</div>
										<a href="<c:url value = "/detail?id=${video.id }"/>" class="text-light py-1"><small><c:out value="${video.title }" /></small></a>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>

						<!-- Single item -->
						<div class="carousel-item">
							<div class="container">
								<div class="row">
									<c:forEach var="video" items="${view_slide2 }">
										<!--Video col_3-->
										<div class="col-6 col-md-3">
											<div class="bg-image hover-overlay ripple position-relative"
												data-mdb-ripple-color="light">
												<img src="<c:url value = "/uploads/"/>${video.poster }" class="img-fluid" />
										
											<div class="mask" style="background-color: rgba(251, 251, 251, 0.2)">
												<a href="<c:url value = "/detail?id=${video.id }"/>"><i
													class="far fa-play-circle fa-5x position-absolute top-50 start-50 translate-middle"></i></a>
											</div>
										</div>
										<a href="<c:url value = "/detail?id=${video.id }"/>" class="text-light py-1"><small><c:out value="${video.title }" /></small></a>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
					<!-- Inner -->
					<button
						class="carousel-control-prev position-absolute top-50 start-0 translate-middle"
						type="button" data-mdb-target="#carouselBasicExample"
						data-mdb-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					</button>
					<button
						class="carousel-control-next position-absolute top-50 start-100 translate-middle"
						type="button" data-mdb-target="#carouselBasicExample"
						data-mdb-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
					</button>
				</div>
			</div>
			<!-- Carousel wrapper -->
		</div>
	</section>
	<hr>
	<!-- Section: Video TOP 8 -->

	<!-- Section: Video Action -->
	<section class="">
		<div class="container text-light my-5">
			<h4 class="text-uppercase black-text mx-3"><i class="fas fa-film"></i>  TẤT CẢ</h4>
			<!-- Carousel wrapper -->

			<!-- Controls -->
			<div class="d-flex justify-content-center mb-4">

				<div class="container">
					<div class="row">
						<!--Item 1-->
						<c:forEach var="video" items="${showAll }">
							<!--Video Item-->
							<div class="col-6 col-md-2 py-3 span3 wow swing center">
								<div class="bg-image hover-overlay ripple position-relative"
									data-mdb-ripple-color="light">
									<img src="<c:url value = "/uploads/"/>${video.poster }"
										class="img-fluid" />
									<div class="mask"
										style="background-color: rgba(251, 251, 251, 0.2)">
										<a href="<c:url value = "/detail?id=${video.id }"/>"><i
											class="far fa-play-circle fa-5x position-absolute top-50 start-50 translate-middle"></i></a>

									</div>
								</div>
								<a href="<c:url value = "/detail?id=${video.id }"/>"><small
									class="text-light py-1">${video.title }</small></a>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Section: Video action -->

	


	<br>
	<jsp:include page="/views/user/layout/footer.jsp"></jsp:include>

	<jsp:include page="/views/user/layout/modalShare.jsp"></jsp:include>
</body>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.1/mdb.min.js"></script>
<script src="https://wowjs.uk/dist/wow.min.js"></script>
<script>
	new WOW().init();
</script>


</html>