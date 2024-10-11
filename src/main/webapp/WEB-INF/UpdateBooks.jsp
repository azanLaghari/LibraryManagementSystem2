<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Update Books</title>
<style>
 #authorId {
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
        <h2 style="text-align: center;">Update Books </h2>
        <form action="editBooksServlet" method="post">
            <input type="text" bookId="bookId" name="bookId" value= "${book.bookId}" class="form-input" hidden><br><br>
            <label for="bookName" class="form-label">BookName:</label>
            <input type="text" bookId="bookName" name="bookName" value= "${book.bookName}" class="form-input" required><br><br>
            
            <label for="bookReviews" class="form-label">Book Reviews:</label>
            <select name="bookReviews" id="bookReviews">
			        <option value="0">0</option>
			        <option value="1">1</option>
			        <option value="2">2</option>
			        <option value="3">3</option>
			        <option value="4">4</option>
			        <option value="5">5</option>
			        <option value="6">6</option>
			        <option value="7">7</option>
			        <option value="8">8</option>
			        <option value="9">9</option>
			</select>
            <br><br>
            
            <label for="bookQuantity" class="form-label">BookQuantity:</label>
            <input type="text" bookId="bookQuantity" name="bookQuantity" value= "${book.bookQuantity}" class="form-input" required><br><br>
            
            <label for="publishedDate" class="form-label">PublishedDate:</label>
            <input type="publishedDate" bookId="publishedDate" name="publishedDate" value= "${book.publishedDate}" class="form-input" required><br><br>
            
            <label for="authorId" class="form-label">Author:</label>				
			<select name="authorId" id="authorId">
			    <c:forEach var="author" items="${authors}">
			        <option value="${author.authorId}">
                <c:out value="${author.authorName}"/>
                </option>
			    </c:forEach>
			</select>
            <br><br>
            
            <input type="submit" value="update" class="form-submit">
        </form>
    </div>

</body>
</html>