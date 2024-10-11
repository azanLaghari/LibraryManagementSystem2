package books;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import author.AuthorDao;


/**
 * Servlet implementation class DeleteBooksServlet
 */
@WebServlet("/DeleteBooksServlet")
public class DeleteBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	BookDao bookDao = new BookDao();
		String bookId = request.getParameter("bookId");
		
		 boolean deleted;
		try {
			
			deleted = bookDao.deleteBooks(Integer.parseInt(bookId));
		
			 if (deleted) {
		            request.setAttribute("message", "Record deleted successfully");
		           
		        } else {
		            request.setAttribute("error", "Failed to delete record");
		        }
			 
			 response.sendRedirect("booksList");
			 
			 
	
		} catch (Exception e) {
			
			e.printStackTrace();
        }
	}
	
	}