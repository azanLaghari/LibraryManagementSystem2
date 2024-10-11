<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title> BooksOutList</title>
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
		<div class="form-container">
			<form action="pageControllerServletAuthor" method="get">
				<input type="hidden" name="page" value="author"> <input
					type="submit" value="Authors">
			</form>

			<form action="PageControllerServletMembers" method="get">
				<input type="hidden" name="page" value="members"> <input
					type="submit" value="Members">
			</form>

			<form action="pageControllerServletLibrarian" method="get">
				<input type="hidden" name="page" value="librarian"> <input
					type="submit" value="Librarians">
			</form>

			<form action="pageControllerServletBooks" method="get">
				<input type="hidden" name="page" value="books"> <input
					type="submit" value="Books">
			</form>

			<form action="pageControllerServletBooksOut" method="get">
				<input type="hidden" name="page" value="booksOut"> <input
					type="submit" value="BooksOut">
			</form>
		</div>
	</div>
<center>
  <h2>BooksOut List</h2>
  
         <form action="registerBooksOut" method="get">
       <form>
			<input type="hidden" name="AddNewBooksOut">
				<input type="submit" value="Add New BooksOut">
		</form>
		<br />
    
    <table border="1">
        <thead>
        <tr>
                <th>Id</th>          
                <th>BookId</th>
                <th>MemberId</th>
                <th>AuthorId</th>
                <th>DateOfOut</th>
                <th>DateOfReturn</th>
                <th>LibrarianId</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="booksOut" items="${booksOutList}">
            <tr>
                <td>${booksOut.id}</td>
                <td>${booksOut.bookId}</td>
                <td>${booksOut.memberId}</td>
                <td>${booksOut.authorId}</td>
                <td>${booksOut.dateOfOut}</td>
                <td>${booksOut.dateOfReturn}</td>
                <td>${booksOut.librarianId}</td>
                <td><a href="editBooksOutServlet?id=${booksOut.id}">Edit</a></td>
                <td>
                    <form action="deleteBooksOut" method="post">
                 <input type="hidden" name="id" value="${booksOut.id}">
                 <input type="submit" value="Delete">
               
                </form>
           </td>
              </tr>
            </c:forEach>
        </tbody>
    </table>
</center>    
</body>
</html>