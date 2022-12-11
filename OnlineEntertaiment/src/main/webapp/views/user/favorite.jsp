<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Entertainment: Favorite</title>
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
	background-color: #111; @media ( min-width : 480px) { #logo {
	display: none;
}
}
}
</style>
</head>
<body class="">
	
	<!-- Navbar -->
	<jsp:include page="/views/user/layout/menu.jsp"></jsp:include>

	<!-- Section: Video Action -->
	<section class="" style="margin-top: 58px">
		<div class="container text-light my-5">
			<h1 class="text-warning">My favorite</h1>
			<!-- Carousel wrapper -->

			<!-- Controls -->
			<div class="d-flex justify-content-center mb-4">

				<div class="container">
					<div class="row">
						<!--Item 1-->
						<c:forEach var="video" items="${items_favorite }">
							<!--Video Item-->
							<div class="col-6 col-md-2 py-3">
								<div class="bg-image hover-overlay ripple position-relative"
									data-mdb-ripple-color="light">
									<img src="<c:url value = "/uploads/${video.video.poster}"/>"
										class="img-fluid" />
									<div class="mask"
										style="background-color: rgba(251, 251, 251, 0.2)">
										<a href="<c:url value = "/detail?id=${video.video.id}"/>"><i
											class="far fa-play-circle fa-5x position-absolute top-50 start-50 translate-middle"></i></a>

									</div>
								</div>
								<a href="<c:url value = "/detail?id=${video.video.id }"/>"><small
									class="text-light py-1">${video.video.title }</small></a>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Section: Video action -->

	<hr>
	

	<br>

	<jsp:include page="/views/user/layout/modalShare.jsp"></jsp:include>
</body>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.1/mdb.min.js"></script>
<script src="https://wowjs.uk/dist/wow.min.js"></script>
<script>
	new WOW().init();
</script>
</html>