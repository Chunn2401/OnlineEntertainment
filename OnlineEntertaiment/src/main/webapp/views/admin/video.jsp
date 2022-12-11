
%@ page language="java" contentType="text/html; charset=UTF-8"
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
<link rel="stylesheet" href="<c:url value = "/templates/admin/css/style.css"/>" /></head>
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
		<p class="display-5">
			<a href="<c:url value = "/dashboard/Video"/>">Manager Video</a>
		</p>
		<c:if test="${not empty message}">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		<c:if test="${not empty error}">
			<div class="alert alert-danger" role="alert">${error}</div>
		</c:if>
		
		<form method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-3">
					<div class="card" style="width: 80%;">
					  <img src="<c:url value = "/uploads/"/>${video_one.poster }" class="card-img-top" alt="${video_one.poster }"/>
					  <div class="card-body">
					   <input type="file" class="form-control" id="poster" name="poster" />
					  </div>
					</div>
					
				</div>
				
				<div class="col-9">
					<!-- ID input -->
					<div class="form-outline mb-4">
						<input type="text" id="id" name="id" class="form-control"
							value="${video_one.id }" />
						<label class="form-label" for="id">Video ID</label>
					</div>
		
					<!-- Title input -->
					<div class="form-outline mb-4">
						<input type="text" id="title" name="title"
							class="form-control" value="${video_one.title }" />
						<label class="form-label" for="title">Title</label>
					</div>
		
					<!-- Views input -->
					<div class="form-outline mb-4">
						<input type="text" id="views" name="views" class="form-control" value="${video_one.views }" />
						<label class="form-label" for="views">Views</label>
					</div>
		
					<!-- Description input -->
					<div class="form-outline mb-4">
						  <textarea class="form-control" id="description" name="description" rows="4" ><c:out value="${video_one.description }" /></textarea>
						<label class="form-label" for="email">Description</label>
					</div>
					
					<!-- Radio input -->
					<div class="m-2">
						<label class="form-check-label" for="inlineRadio2">Active: </label>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="active"
								id="active" value="true" ${video_one.active? 'checked':'' } />
							<label class="form-check-label" for="active">Active</label>
						</div>
		
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="active" id="no_active"
								value="false" ${!video_one.active? 'checked':'' } />
							<label class="form-check-label" for="no_active">No Active</label>
						</div>
					</div>
				</div>
			</div>
			
			
			

			<!-- Submit button -->
			<button class="btn btn-primary" formaction="dashboard/video/create">
				Create</button>
			<button class="btn btn-secondary" formaction="dashboard/video/update">Update</button>
			<button class="btn btn-danger" formaction="dashboard/video/delete">Delete</button>
			<button class="btn btn-success" formaction="dashboard/video/reset">Reset</button>
		</form>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Title</th>
					<th scope="col">Views</th>
					<th scope="col">Active</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>

			<c:forEach var="item" items="${video }">
				<tbody>
					<tr>
						<th><c:out value="${item.id}" /></th>
						<th><c:out value="${item.title}" /></th>
						<th><c:out value="${item.views}" /></th>
						<th><c:out value="${item.active? 'Active':'No Active'}" /></th>
						<td><a href="dashboard/video/edit?id=<c:out value="${item.id}"/>">Edit</a>
							<a href="dashboard/video/delete?id=<c:out value="${item.id}"/>">Delete</a>
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
<script type="text/javascript" src="<c:url value = "/templates/admin/js/script.js"/>"></script>
</html>