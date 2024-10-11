package author;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class EditServletAuthor
 */
@WebServlet("/editServletAuthor")
public class EditServletAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServletAuthor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	
    	AuthorDao authorDao = new AuthorDao();
		AuthorModel author = authorDao.selectAuthorById(Integer.parseInt(request.getParameter("authorId")));
   		request.setAttribute("author", author);
   		String jspPage = "/WEB-INF/UpdateAuthor.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
 		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		    AuthorDao  authorDao = new  AuthorDao(); 
	        
	        String authorId=request.getParameter("authorId");
	        String authorName=request.getParameter("authorName");  
	        String authorDateofBirth=request.getParameter("authorDateofBirth");  
	        String authorReview=request.getParameter("authorReview");  
	   
	        AuthorModel  author = new AuthorModel();  
	        author.setAuthorId(Integer.parseInt(authorId));  
	        author.setAuthorName(authorName);  
	        author.setAuthorDateofBirth(authorDateofBirth);  
	        author.setAuthorReview(authorReview);  
	       
	        try {
	        	authorDao.updateAuthor(author);
	       
	        	response.sendRedirect("authorList");
	        
	        	// redirect to author table
	        
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
	        
	}
}

