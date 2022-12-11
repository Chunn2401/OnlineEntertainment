<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change password</title>
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
		<h4 class="py-4 text-center text-light">
			Change Password
		</h4>
		<c:if test="${not empty message}">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		<c:if test="${not empty error}">
			<div class="alert alert-danger" role="alert">${error}</div>
		</c:if>
		<form class="col-md-6 m-auto" action="<c:url value = "/account/change-password"/>" method="post">
			<!-- PASSWORD input -->
			<div class="form-outline mb-4">
				<input type="password" id="password" name="password"
					class="form-control text-light" value="" /> <label
					class="form-label text-light" for="password">Password</label>
			</div>
			
			<!-- PASSWORD-NEW input -->
			<div class="form-outline mb-4">
				<input type="password" id="password" name="password_new"
					class="form-control text-light" value="" /> <label
					class="form-label text-light" for="password">Password new</label>
			</div>
			
			<!-- RE-PASSWORD-NEW input -->
			<div class="form-outline mb-4">
				<input type="password" id="password" name="re_password_new"
					class="form-control text-light" value="" /> <label
					class="form-label text-light" for="password">Re-Password new</label>
			</div>
			<!-- Submit button -->
			<button class="btn btn-secondary btn-block mb-4" type="submit">Change password</button>
		</form>
	</div>
</body>
<!-- MDB -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.js">
</script>
</html>