package dashBorad;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DashBoradServlet
 */
@WebServlet("/DashBoradServlet")
public class DashBoradServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashBoradServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String page = request.getParameter("page");
        if ("author".equals(page)) {
        	 String authorTablePage = "/WEB-INF/AuthorTable.jsp";
             RequestDispatcher dispatcher = request.getRequestDispatcher(authorTablePage);
             request.setAttribute("successfully", dispatcher);
              dispatcher.forward(request, response);
              
        } else if ("Members".equals(page)) {
            response.sendRedirect("Members.jsp");
        } else if ("Books".equals(page)) {
            response.sendRedirect("Books.jsp");
        } else if ("Librarian".equals(page)) {
            response.sendRedirect("Librarian.jsp");
        } else if ("UtilBooksOut".equals(page)) {
            response.sendRedirect("UtilBooksOut.jsp");
        } else {
            response.sendRedirect("error.jsp"); // Redirect to an error page or handle it as needed
        }
    }

}


