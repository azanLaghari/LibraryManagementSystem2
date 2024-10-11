<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Update Librarian</title>
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
        <h2 style="text-align: center;">Update Librarian Form</h2>
        <form action="editLibrarianServlet" method="post">
        
            <input type="text" librarianId="librarianId" name="librarianId" value= "${librarian.librarianId}" class="form-input" hidden><br><br>
            
             <label for="name" class="form-label">Name:</label>
            <input type="text" librarianId="name" name="name" value= "${librarian.name}" class="form-input" required><br><br>
            
            <label for="userName" class="form-label">UserName:</label>
            <input type="text"librarianId="userName" name="userName" value= "${librarian.userName}"  class="form-input" required><br><br>
            
              <label for="password" class="form-label">Password:</label>
            <input type="text" librarianId="password" name="password" value= "${librarian.password}" class="form-input" required><br><br>
           
              <label for="dateOfBirth" class="form-label">DateOfBirth:</label>
            <input type="text" librarianId="dateOfBirth" name="dateOfBirth" value= "${librarian.dateOfBirth}" class="form-input" required><br><br>
         
            <input type="submit" value="update" class="form-submit">
        </form>
    </div>
</body>
</html>