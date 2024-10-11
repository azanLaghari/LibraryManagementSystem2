package librarian;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import librarian.LibrarianDao;
import librarian.LibrarianModel;
import util.Util;

/**
 * Servlet implementation class EditLibrarianServlet
 */
@WebServlet("/EditLibrarianServlet")
public class EditLibrarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLibrarianServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	LibrarianDao librarianDao = new LibrarianDao();
		LibrarianModel librarian = librarianDao.selectLibrarianById(Integer.parseInt(request.getParameter("librarianId")));
   		request.setAttribute("librarian", librarian);
   		String jspPage = "/WEB-INF/UpdateLibrarian.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
 		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibrarianDao  librarianDao = new  LibrarianDao(); 
	        
	        String librarianId=request.getParameter("librarianId");
	        String name=request.getParameter("name");  
	        String userName=request.getParameter("userName");  
	        String password=request.getParameter("password"); 
	        String dateOfBirth=request.getParameter("dateOfBirth"); 
	
	        LibrarianModel  librarian = new LibrarianModel();  
	        librarian.setLibrarianId(Integer.parseInt(librarianId));  
	        librarian.setName(name);  
	        librarian.setUserName(userName);  
	        librarian.setPassword(password); 
	        librarian.setDateOfBirth(dateOfBirth);
	        
	          
	        try {
	        	librarianDao.updateLibrarian(librarian);
	        	response.sendRedirect("librarianList");
	       
			} catch (SQLException e1) {
				e1.printStackTrace();
			}  	        
}
} 


