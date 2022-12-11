<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Login Online Entertainment</title>
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
<style type="text/css">
.divider:after, .divider:before {
	content: "";
	flex: 1;
	height: 1px;
	background: #eee;
}
</style>
</head>

<body>

	<section class="vh-100">
		<div class="container py-5 h-100">
			<div
				class="row d-flex align-items-center justify-content-center h-100">
				<div class="col-md-8 col-lg-7 col-xl-6">
					<img
						src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
						class="img-fluid" alt="Phone image">
				</div>
				<div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
					<h1 class="text-center">Sign-in</h1>
					<form action="<c:url value = "/account/sign-in"/>" method="post">
						<!-- Email input -->
						<div class="form-outline mb-4">
							<input type="text" id="username" name="username"
								value="${username }" class="form-control form-control-lg" /> <label
								class="form-label" for="username">Username</label>
						</div>

						<!-- Password input -->
						<div class="form-outline mb-4">
							<input type="password" id="password" name="password"
								value="${password }" class="form-control form-control-lg" /> <label
								class="form-label" for="password">Password</label>
						</div>

						<!-- Submit button -->
						<div class="form-outline mb-4">
							<button type="submit" class="btn btn-primary btn-lg btn-block">Sign
								in</button>
						</div>

						<div class="d-flex justify-content-around align-items-center mb-4">
							<a href="<c:url value = "/account/sign-up"/>">SignUp</a> <a
								href="<c:url value = "/account/forgot-password"/>">Forgot
								password?</a>
						</div>

						<c:if test="${not empty message}">
							<div class="alert alert-success my-4" role="alert">${message}</div>
						</c:if>

						<div class="divider d-flex align-items-center my-4">
							<p class="text-center fw-bold mx-3 mb-0 text-muted">OR</p>
						</div>

					</form>
					<center>
						<div class="fb-login-button" onlogin="checkLoginState();"
							data-width="" data-size="large" data-button-type="login_with"
							data-layout="default"></div>
					</center>





				</div>
			</div>
		</div>
	</section>

</body>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.1/mdb.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script async defer crossorigin="anonymous"
	src="https://connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v13.0&appId=493217671994959&autoLogAppEvents=1"
	nonce="hPIgvVEf"></script>


<script type="text/javascript">
	function statusChangeCallback(response) { // Called with the results from FB.getLoginStatus().
		console.log('statusChangeCallback');
		console.log(response); // The current login status of the person.
		if (response.status === 'connected') { // Logged into your webpage and Facebook.
			testAPI();
		} else { // Not logged into your webpage or we are unable to tell.
			document.getElementById('status').innerHTML = 'Please log '
					+ 'into this webpage.';
		}
	}

	function checkLoginState() { // Called when a person is finished with the Login Button.
		FB.getLoginStatus(function(response) { // See the onlogin handler
			statusChangeCallback(response);
		});
	}

	window.fbAsyncInit = function() {
		FB.init({
			appId : '{493217671994959}',
			cookie : true, // Enable cookies to allow the server to access the session.
			xfbml : true, // Parse social plugins on this webpage.
			version : '{v13.0}' // Use this Graph API version for this call.
		});

		FB.getLoginStatus(function(response) { // Called after the JS SDK has been initialized.
			statusChangeCallback(response); // Returns the login status.
		});
	};

	function testAPI() { // Testing Graph API after login.  See statusChangeCallback() for when this call is made.
		console.log('Welcome!  Fetching your information.... ');
		FB.api('/me?fields=id,name,email', function(response) {
			console.log('name: ' + response.name);
			console.log('id: ' + response.id);
			console.log('email: ' + response.email);
			$.ajax({
				type : "POST",
				data : {
					id : response.id,
					name : response.name,
					email : response.email
				},
				url : "<c:url value = "/account/loginfb.php"/>"
			}).then(function(data) {
				console.log("done!");
				window.location.href = '<c:url value = "/Homepage"/>';

			}).fail(function(error) {
				console.log("fail!");
				window.location.href = '<c:url value = "/account/sign-in"/>';
			});
		});
	}
</script>

</html>