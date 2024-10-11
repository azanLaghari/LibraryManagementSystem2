package booksOut;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class PageControllerServletBooksOut
 */
@WebServlet("/PageControllerServletBooksOut")
public class PageControllerServletBooksOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageControllerServletBooksOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

    	BookOutDao booksOutD = new BookOutDao();
		List<BooksOutModel> list = booksOutD.getAllBooksOut();
		request.setAttribute("booksOutList", list);
		String jspPage = "/WEB-INF/BooksOutTable.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
