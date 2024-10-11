package books;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import author.AuthorDao;
import author.AuthorModel;



/**
 * Servlet implementation class RegisterBooksServlet
 */
@WebServlet("/RegisterBooksServlet")
public class RegisterBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	AuthorDao autherDao = new AuthorDao(); 
    	List<AuthorModel> authors = autherDao.getAllAuthors();
		String jspPage = "/WEB-INF/RegisterBooks.jsp";
		request.setAttribute("authors", authors);
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
        dispatcher.forward(request, response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 
			try {
			BooksModel book = new BooksModel();
			 book.setBookName(request.getParameter("bookName"));
			 book.setBookReviews(request.getParameter("bookReviews"));
			 book.setBookQuantity(request.getParameter("bookQuantity"));
			 book.setPublishedDate(request.getParameter("publishedDate"));
			 book.setAuthorId(request.getParameter("authorId"));
			
			
			BookDao bookDao = new BookDao();
			bookDao.addBooks(book);
			
			response.sendRedirect("booksList");
			
			 } catch (Exception e) {
			       
			        e.printStackTrace();
			        
			        response.sendRedirect("errorPage.jsp");
			    }
			}
}