package librarian;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RegisterLibrarianServlet
 */
@WebServlet("/RegisterLibrarianServlet")
public class RegisterLibrarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterLibrarianServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jspPage = "/WEB-INF/RegisterLibrarian.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
        dispatcher.forward(request, response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 
			try {
		  LibrarianModel librarian = new LibrarianModel();
		  librarian.setName(request.getParameter("name"));
		  librarian.setUserName(request.getParameter("userName"));
		  librarian.setPassword(request.getParameter("password"));
		  librarian.setDateOfBirth(request.getParameter("dateOfBirth"));
			
			
			LibrarianDao librarianDao = new LibrarianDao();
			librarianDao.addLibrarian(librarian);
			
			response.sendRedirect("librarianList");
			
			 } catch (Exception e) {
			       
			        e.printStackTrace();
			        
			        response.sendRedirect("errorPage.jsp");
			    }
			}
}