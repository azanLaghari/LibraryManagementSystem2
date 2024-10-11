package books;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import author.AuthorDao;
import author.AuthorModel;

//import books.BookDao;
//import books.BooksModel;


/**
 * Servlet implementation class EditBooksServlet
 */
@WebServlet("/EditBooksServlet")
public class EditBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	BookDao bookDao = new BookDao();
    	BooksModel book = bookDao.selectBooksById(Integer.parseInt(request.getParameter("bookId")));
    	request.setAttribute("book", book);
  
    	AuthorDao autherDao = new AuthorDao(); 
    	List<AuthorModel> authors = autherDao.getAllAuthors();
   		String jspPage = "/WEB-INF/UpdateBooks.jsp";
   		request.setAttribute("authors", authors);
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
 		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		    BookDao  bookDao = new  BookDao(); 
	        
	        String bookId=request.getParameter("bookId");
	        String bookName=request.getParameter("bookName");  
	        String bookReviews=request.getParameter("bookReviews"); 
	        String bookQuantity=request.getParameter("bookQuantity"); 
	        String publishedDate=request.getParameter("publishedDate"); 
	        String authorId=request.getParameter("authorId"); 
	
	        BooksModel book = new BooksModel();  
	        book.setBookId(Integer.parseInt(bookId));  
	        book.setBookName(bookName);  
	        book.setBookReviews(bookReviews); 
	        book.setBookQuantity(bookQuantity); 
	        book.setPublishedDate(publishedDate); 
	        book.setAuthorId(authorId); 
	        
	          
	        try {
	        	bookDao.updateBooks(book);
	        	response.sendRedirect("booksList");
		        
			} catch (SQLException e1) {
				e1.printStackTrace();
			}  	        
}
} 

