<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Update Members</title>
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
<div class="container">
        <h2 style="text-align: center;">Update Members Form</h2>
        <form action="editMembersServlet" method="post">
        
            <input type="text" memberId="memberId" name="memberId" value= "${members.memberId}" class="form-input" hidden><br><br>
            
            <label for="firstName" class="form-label">FirstName:</label>
            <input type="text" memberId="firstName" name="firstName" value= "${members.firstName}" class="form-input" required><br><br>
           
            <label for="lastName" class="form-label">LastName:</label>
            <input type="lastName" memberId="lastName" name="lastName" value= "${members.lastName}" class="form-input" required><br><br>
           
            <label for="dateOfBirth" class="form-label">DateOfBirth:</label>
            <input type="dateOfBirth" memberId="dateOfBirth" name="dateOfBirth" value= "${members.dateOfBirth}" class="form-input" required><br><br>
            
           <input type="submit" value="update" class="form-submit">
        </form>
    </div>
</body>
</html>