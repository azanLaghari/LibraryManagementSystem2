package author;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteAuthorServlet
 */
@WebServlet("/DeleteAuthorServlet")
public class DeleteAuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAuthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	AuthorDao authorDao = new AuthorDao();
		String authorId = request.getParameter("authorId");
		
		 boolean deleted;
		try {
			
			deleted = authorDao.deleteAuthor(Integer.parseInt(authorId));
		
			 if (deleted) {
		            request.setAttribute("message", "Record deleted successfully");
		           
		        } else {
		            request.setAttribute("error", "Failed to delete record");
		        }
			 
			 response.sendRedirect("authorList");
			 
			 
	
		} catch (Exception e) {
			
			e.printStackTrace();
        }
	}
	
	}


