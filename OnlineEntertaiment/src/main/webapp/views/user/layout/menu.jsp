<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!-- Navbar -->
<nav id="main-navbar"
	class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<!-- Container wrapper -->
	<div class="container-fluid position-relative">
		<button class="navbar-toggler" type="button"
			data-mdb-toggle="collapse" data-mdb-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<i class="fas fa-bars"></i>
		</button>

		<!-- Brand -->
		<a class="navbar-brand mt-2 mt-lg-0 d-none " href="#" id="logo"> <img
			src="https://cdn.popsww.com/popsapp/assets/images/icons/logo-pops.png"
			height="15" alt="MDB Logo" />
		</a>

		<!-- Collapsible wrapper -->
		<div class="collapse navbar-collapse justify-content-center"
			id="navbarSupportedContent">
			<!-- Left links -->
			<ul class="navbar-nav mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active navbar-brand"
					aria-current="page" href="<c:url value = "/Homepage"/>">Online Entertainment</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Phim bộ hot</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Tết 2022</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Anime</a></li>
				<li class="nav-item"><a class="nav-link" href="#">HBO GO</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Thể thao</a></li>
				<li class="nav-item"><a class="nav-link" href="#">TV Show</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Phim lẻ</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Phim chiếu rạp</a></li>
				
			</ul>
			<!-- Left links -->
		</div>
		<!-- Collapsible wrapper -->
		<c:if test="${sessionScope.user != null}">
			<!-- Right links -->
			<ul
				class="navbar-nav ms-auto d-flex flex-row position-absolute top-0 end-0 mx-3">


				<!-- Icon -->
				<li class="nav-item"><a class="nav-link me-3 me-lg-0" href="<c:url value = "/search"/>">
						<i class="fas fa-search"></i>
				</a></li>
				<li class="nav-item"><a class="nav-link me-3 me-lg-0" href="<c:url value = "/account/favorite"/>">
						<i class="fas fa-heart"></i>
				</a></li>
				<li class="nav-item"><a class="nav-link me-3 me-lg-0"><c:out value="${sessionScope.user.fullname }" /></a></li>
				<!-- Avatar -->
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle hidden-arrow d-flex align-items-center"
						href="#" id="navbarDropdownMenuLink" role="button" data-mdb-toggle="dropdown" aria-expanded="false">
						<img src="https://mdbootstrap.com/img/Photos/Avatars/img (31).jpg" class="rounded-circle" height="22" alt="" />
					</a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdownMenuLink">
						<li><a class="dropdown-item" href="<c:url value = "/account/edit-profile"/>">My profile</a></li>
						<li><a class="dropdown-item" href="<c:url value = "/account/change-password"/>">Change password</a></li>
						<c:if test="${sessionScope.user.admin }">
							<li><hr class="dropdown-divider" /></li>
							<li><a class="dropdown-item" href="<c:url value = "/dashboard/homepage"/>">Dashboard</a></li>
						</c:if>
						<li><hr class="dropdown-divider" /></li>
						<li><a class="dropdown-item" href="<c:url value = "/account/sign-out"/>">Logout</a></li>
					</ul></li>
			</ul>
			<!-- Right links -->
		</c:if>
		<c:if test="${sessionScope.user == null}">
			<!-- Right links -->
			<ul
				class="navbar-nav ms-auto d-flex flex-row position-absolute top-0 end-0 mx-3">
				<!-- Notification dropdown -->
				<li class="nav-item"><a class="nav-link me-3 me-lg-0"
					href="<c:url value = "/account/sign-in"/>">
						<button type="button"
							class="btn btn-outline-danger btn-rounded btn-sm"
							data-mdb-ripple-color="dark">Sign-in</button>
				</a></li>


				<!-- Icon -->
				<li class="nav-item"><a class="nav-link me-3 me-lg-0"
					href="<c:url value = "/account/sign-up"/>">
						<button type="button" class="btn btn-danger btn-rounded btn-sm">Sign-up</button>
				</a></li>

			</ul>
			<!-- Right links -->
		</c:if>
	</div>
	<!-- Container wrapper -->
</nav>
<!-- Navbar -->