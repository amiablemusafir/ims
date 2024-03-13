<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
  	<title>Inventory Management System</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="login/css/style.css">
	
	<script language="javascript" type="text/javascript" src="login/js/md5hash.js"></script>
	<style>
	#grad1 {
	   background-image: linear-gradient(to right, rgba(255,0,0,0), rgba(1 14 14));
	}
	body {
	    background-image:url("login/images/login_bg_hd.jpg");
	    background-repeat: no-repeat;
	    background-size: 100% 100%;
	}
	html {
	    height: 120%
	}
	</style>
	<script type="text/javascript">
			function LoginValidation() {
		
				var username = document.getElementById('username').value;
				var password = document.getElementById('password').value;
				
				if (username == '') {
					alert('Please enter Username');
					return false;
				}
				if (password == '') {
					alert('Please enter Password');
					return false;
				} else {				
					var hashPass = calcMD5(password);
					document.getElementById('password').value = hashPass;
				}
				return true;
			}
	</script>
	</head>	
	<body>
	<div>
	<section class="ftco-section">
		<div class="container">
			<!-- 
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Login #04</h2>
				</div>
			</div>
			-->
			<div class="row justify-content-center">
				<div class="col-md-12 col-lg-10">
					<div class="wrap d-md-flex">
						<div class="img" style="background-image: url(login/images/login_bg.jpeg);">
			      </div>
						<div class="login-wrap p-4 p-md-5">
			      	<div class="d-flex">
			      		<div class="w-100">
			      			<h3 class="mb-4">Sign In</h3>	
			      			
			      		</div>
								<div class="w-100">
									<p class="social-media d-flex justify-content-end">
									
									</p>
								</div>
			      	</div>
			      	<div th:if="${param.error}">		      			
			                <div class="alert alert-danger">Invalid Email or Password</div>
			            </div>
			            <form method="post" th:action="@{/authentication}"
                            class="form-horizontal"
                            role="form" onsubmit="return(LoginValidation());" autocomplete="on">
					
			      		<div class="form-group mb-3">
			      			<label class="label" for="name">Username</label>
			      			<input type="text" name="username" id="username" class="form-control" placeholder="Username" required>
			      		</div>
		            <div class="form-group mb-3">
		            	<label class="label" for="password">Password</label>
		              <input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
		            </div>
		            <div class="form-group">
		            	<button type="submit" class="form-control btn btn-primary rounded submit px-3">Sign In</button>
		            </div>
		            <div class="form-group d-md-flex">
		            	<div class="w-50 text-left">
			            	<label class="checkbox-wrap checkbox-primary mb-0">Remember Me
									  <input type="checkbox" checked>
									  <span class="checkmark"></span>
										</label>
									</div>
									<div class="w-50 text-md-right">
										<a href="#">Forgot Password</a>
									</div>
		            </div>
		          </form>
		          <p class="text-center">Not a member? <a data-toggle="tab" href="#signup">Sign Up</a></p>
		        </div>
		      </div>
				</div>
			</div>
		</div>
	</section>
	</div>
	<script src="login/js/jquery.min.js"></script>
  <script src="login/js/popper.js"></script>
  <script src="login/js/bootstrap.min.js"></script>
  <script src="login/js/main.js"></script>

	</body>
</html>

