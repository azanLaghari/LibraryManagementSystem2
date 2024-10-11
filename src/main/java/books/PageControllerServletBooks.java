package books;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class PageControllerServletBooks
 */
@WebServlet("/PageControllerServletBooks")
public class PageControllerServletBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageControllerServletBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      
    	BookDao bookD = new BookDao();
		List<BooksModel> list = bookD.getAllBooks();
		request.setAttribute("booksList", list);
		String jspPage = "/WEB-INF/BooksTable.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
