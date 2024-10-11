<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login </title>
<meta charset="UTF-8">
	<title>Login</title>
</head>
<body>
	<style>
body {
	background-color: #f0f0f0;
	/* Set a background color for the entire page */
}

.container {
	margin-top: 50px !important;
	width: 30%; /* Set a width for the container */
	margin: 0 auto; /* Center align the container horizontally */
	padding: 20px;
	background-color: #46807E;
	/* Set a background color for the container */
	border-radius: 10px;
	/* Optional: Add rounded corners to the container */
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	/* Optional: Add a subtle shadow */
}

.form-label {
	display: block;
	margin-bottom: 10px;
}

.form-input {
	width: 100%;
	padding: 8px;
	margin-bottom: 15px;
	box-sizing: border-box;
	/* Ensure padding and border are included in width */
}

.form-submit {
	padding: 10px 20px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
}

.form-submit:hover {
	background-color: #45a049;
}

</style>
	</head>
	<body>
		<%-- Display success message --%>
		<% if (request.getAttribute("message") != null) { %>
		<div class="success-message">${request.getAttribute("message")}</div>
		<% } %>

		<%-- Display error message --%>
		<% if (request.getAttribute("error") != null) { %>
		<div class="error-message">${request.getAttribute("error")}</div>
		<% } %>
		<div class="container">
			<h2 style="text-align: center;">Login Form</h2>
			<form action="LoginServlet" method="post">

		      <label for="userName" class="form-label">UserName:</label> 
	   <input type="text" id="userName" name="userName"placeholder="user Name" class="form-input"required><br><br> 
			
	         <label for="password"class="form-label">Password:</label>
	   <input type="password"id="password" name="password"placeholder="password" class="form-input" required><br><br>

					<input type="submit" value="Login" class="form-submit">
			</form>

		</div>

	</body>
</html>

</body>
</html>