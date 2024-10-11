package author;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterAuthor
 */
@WebServlet("/RegisterAuthor")
public class RegisterAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAuthor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String jspPage = "/WEB-INF/RegisterAuthor.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
        dispatcher.forward(request, response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 
			try {
			AuthorModel author = new AuthorModel();
			author.setAuthorName(request.getParameter("authorName"));
			author.setAuthorDateofBirth(request.getParameter("authorDateofBirth"));
			author.setAuthorReview(request.getParameter("authorReview"));
			
			
			AuthorDao authorDao = new AuthorDao();
			authorDao.addAuthor(author);
			
			response.sendRedirect("authorList");
			
			 } catch (Exception e) {
			       
			        e.printStackTrace();
			        
			        response.sendRedirect("errorPage.jsp");
			    }
			}
}