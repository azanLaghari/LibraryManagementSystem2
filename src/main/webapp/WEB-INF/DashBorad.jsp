<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Dash Board</title>
<meta charset="UTF-8">
<style>
body {
	background-color: #f0f0f0;
	/* Set a background color for the entire page */
}

.container {
	margin-top: 50px !important;
	width: 60%; /* Increased width to fit all forms horizontally */
	margin: 0 auto; /* Center align the container horizontally */
	padding: 20px;
	background-color: #46807E;
	/* Set a background color for the container */
	border-radius: 10px;
	/* Optional: Add rounded corners to the container */
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	/* Optional: Add a subtle shadow */
}

.container h2 {
	text-align: center;
}

.form-container {
	display: flex;
	justify-content: center;
	gap: 10px; /* Space between forms */
	flex-wrap: wrap; /* Wrap forms to next line if needed */
}

form {
	margin: 0;
}

input[type="submit"] {
	padding: 10px 20px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
	font-size: 16px; /* Adjust font size as needed */
}

input[type="submit"]:hover {
	background-color: #45a049;
}

.logout{
  margin-top: 10px;
  margin-left:75%; 
}
</style>
</head>
<body>
   <form action="#" method="get">
				<input class="logout" type="submit" value="Logout">
			</form>
	<div class="container">
		<h2>Dash Board</h2>
		
		<div class="form-container">
			<form action="pageControllerServletAuthor" method="get">		
				<input type="hidden" name="page" value="author"> 
				<input type="submit" value="Authors">
			</form>
			
			<form action="pageControllerServletMembers" method="get">
				<input type="hidden" name="page" value="members"> 
				<input type="submit" value="Members">
			</form>
			
			<form action="pageControllerServletLibrarian" method="get">
				<input type="hidden" name="page" value="librarian"> 
				<input type="submit" value="Librarians">
			</form>
			
			<form action="pageControllerServletBooks" method="get">
				<input type="hidden" name="page" value="books"> 
				<input type="submit" value="Books">
			</form>
			
			<form action="pageControllerServletBooksOut" method="get">
				<input type="hidden" name="page" value="booksOut"> 
				<input type="submit" value="BooksOut">
			</form>
		</div>
	
</body>
</html>
