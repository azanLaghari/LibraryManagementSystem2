package librarian;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import librarian.LibrarianDao;
import librarian.LibrarianModel;


/**
 * Servlet implementation class PageControllerServletLibrarian
 */
@WebServlet("/PageControllerServletLibrarian")
public class PageControllerServletLibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageControllerServletLibrarian() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

    	LibrarianDao librarianD = new LibrarianDao();
		List<LibrarianModel> list = librarianD.getAllLibrarian();
		
		request.setAttribute("librarianList", list);
		String jspPage = "/WEB-INF/LibrarianTable.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}