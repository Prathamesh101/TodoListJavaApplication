 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title> Login Page</title>
		<link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
	<div class= "container">
	<h1>Login Page</h1>
	<form method="POST">
			<div>
			Enter Username: <input type="text" name="name"></input>
    		Enter Password: <input type = "password" name="password"></input>
    		</div>
    		<div><button class="btn btn-primary" type= "submit">Submit</button></div>
	</form>
	</div>
		<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.4/jquery.min.js"></script>
	</body>

</html>