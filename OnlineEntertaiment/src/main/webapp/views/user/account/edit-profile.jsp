<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
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

<style type="text/css">
body {
	background-color: #111; @media ( min-width : 480px) { #logo {
	display: none;
}
}
}
</style>
</head>
<body>
	<%@include file="/views/user/layout/menu.jsp"%>"%>

	<div class="container" style="margin-top: 58px">

		<h4 class="py-4 text-center text-light">Edit Profile</h4>
		<c:if test="${not empty message}">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		<c:if test="${not empty error}">
			<div class="alert alert-danger" role="alert">${error}</div>
		</c:if>
		<form class="col-md-6 m-auto"
			action="<c:url value = "/account/edit-profile"/>" method="post">
			<!-- ID input -->
			<div class="form-outline mb-4 ">
				<input type="text" id="id" class="form-control text-light "
					value="${sessionScope.user.id }" /> <label
					class="form-label text-light " for="id">User ID</label>
			</div>

			<!-- FULLNAME input -->
			<div class="form-outline mb-4">
				<input type="text" id="fullname" name="fullname"
					class="form-control text-light "
					value="${sessionScope.user.fullname }" /> <label
					class="form-label text-light " for="fullname">Fullname</label>
			</div>

			<!-- Email input -->
			<div class="form-outline mb-4">
				<input type="email" id="email" name="email"
					class="form-control text-light "
					value="${sessionScope.user.email }" /> <label
					class="form-label text-light " for="email">Email</label>
			</div>

			<!-- Submit button -->
			<button class="btn btn-primary btn-block mb-4" type="submit">Update</button>
		</form>
	</div>
</body>
<!-- MDB -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.js">
	
</script>
</html>