<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Register BooksOut</title>
	<style>
    #authorId {
        width: 420px; /* Adjust this value as needed */
        height: 35px
     }
     #bookId {
        width: 420px; /* Adjust this value as needed */
        height: 35px   
    }
    #memberId {
        width: 420px; /* Adjust this value as needed */
        height: 35px
        }
  #librarianId {
        width: 420px; /* Adjust this value as needed */
        height: 35px
        }  
    #bookReviews{
     width: 420px; /* Adjust this value as needed */
        height: 35px
   } 
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
        <h2 style="text-align: center;">Register BooksOut</h2>
        
        <form action="registerBooksOut" method="post">
        
       <label for="bookId" class="form-label">Book:</label>				
			<select name="bookId" id="bookId">
			    <c:forEach var="book" items="${books}">
			        <option value="${book.bookId}">
                <c:out value="${book.bookName}"/>
                </option>
			    </c:forEach>
			</select>
            <br><br>
    
    <label for="memberId" class="form-label">Member:</label>				
			<select name="memberId" id="memberId">
			    <c:forEach var="member" items="${members}">
			        <option value="${member.memberId}">
                <c:out value="${member.firstName}"/>
                </option>
			    </c:forEach>
			</select>
            <br><br>
    
   <label for="authorId" class="form-label">Author:</label>				
			<select name="authorId" id="authorId">
			    <c:forEach var="author" items="${authors}">
			        <option value="${author.authorId}">
                <c:out value="${author.authorName}"/>
                </option>
			    </c:forEach>
			</select>
            <br><br>
    
    <label for="dateOfOut" class="form-label">Date of Out:</label>
    <input type="date" id="dateOfOut" name="dateOfOut" class="form-input" required><br><br>
    
    <label for="dateOfReturn" class="form-label">Date of Return:</label>
    <input type="date" id="dateOfReturn" name="dateOfReturn" class="form-input" required><br><br>
    
     <label for="librarianId" class="form-label">Librarian:</label>				
			<select name="librarianId" id="librarianId">
			    <c:forEach var="librarian" items="${librarians}">
			        <option value="${librarian.librarianId}">
                <c:out value="${librarian.name}"/>
                </option>
			    </c:forEach>
			</select>
            <br><br>
    
    <input type="submit" value="Register" class="form-submit">
</form>
    </div>
</body>
</html>