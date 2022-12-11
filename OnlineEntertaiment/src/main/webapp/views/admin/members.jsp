<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard: Manager Users</title>
<base href="/OnlineEntertaiment/">
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
				<h1 class="display-3 text-center">
					<a href="<c:url value = "/dashboard/homepage"/>">Dashboard</a>
				</h1>
				<c:if test="${not empty message}">
					<div class="alert alert-success" role="alert">${message}</div>
				</c:if>
				<c:if test="${not empty error}">
					<div class="alert alert-danger" role="alert">${error}</div>
				</c:if>
				<form action="/dashboard/members" method="post">
					<!-- ID input -->
					<div class="form-outline mb-4">
						<input type="text" id="id" name="id" class="form-control"
							value="${user.id }" /> <label class="form-label" for="id">User
							ID</label>
					</div>

					<!-- PASSWORD input -->
					<div class="form-outline mb-4">
						<input type="password" id="password" name="password"
							class="form-control" value="${user.password }" /> <label
							class="form-label" for="password">Password</label>
					</div>

					<!-- FULLNAME input -->
					<div class="form-outline mb-4">
						<input type="text" id="fullname" name="fullname"
							class="form-control" value="${user.fullname }" /> <label
							class="form-label" for="fullname">Fullname</label>
					</div>

					<!-- Email input -->
					<div class="form-outline mb-4">
						<input type="email" id="email" name="email" class="form-control"
							value="${user.email }" /> <label class="form-label" for="email">Email</label>
					</div>

					<!-- Radio input -->
					<div class="m-2">
						<label class="form-check-label" for="inlineRadio2">Role: </label>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="admin"
								id="admin" value="true" ${user.admin? 'checked':'' } /> <label
								class="form-check-label" for="inlineRadio1">Admin</label>
						</div>

						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="admin"
								id="user" value="false" ${!user.admin? 'checked':'' } /> <label
								class="form-check-label" for="inlineRadio2">User</label>
						</div>
					</div>

					<!-- Submit button -->
					<button class="btn btn-primary"
						formaction="dashboard/members/create">Create</button>
					<button class="btn btn-secondary"
						formaction="dashboard/members/update">Update</button>
					<button class="btn btn-danger"
						formaction="dashboard/members/delete">Delete</button>
					<button class="btn btn-success"
						formaction="dashboard/members/reset">Reset</button>
				</form>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Fullname</th>
							<th scope="col">Password</th>
							<th scope="col">Role</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>

					<c:forEach var="item" items="${users }">
						<tbody>
							<tr>
								<th><c:out value="${item.id}" /></th>
								<th><c:out value="${item.fullname}" /></th>
								<th><c:out value="${item.password}" /></th>
								<th><c:out value="${item.admin? 'Admin':'User'}" /></th>
								<td><a
									href="dashboard/members/edit?id=<c:out value="${item.id}"/>">Edit</a>
									<a
									href="dashboard/members/delete?id=<c:out value="${item.id}"/>">Delete</a>
								</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</section>
		</div>
	</main>
	<!--Main layout-->
</body>
<!-- MDB -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.js"></script>
<!-- Custom scripts -->
<script type="text/javascript"
	src="<c:url value = "/templates/admin/js/script.js"/>"></script>
</html>