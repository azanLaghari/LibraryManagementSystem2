package author;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PageControllerServletAuthor")
public class PageControllerServletAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public PageControllerServletAuthor() {
		super();
	}

	protected  void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		AuthorDao authorD = new AuthorDao();
		List<AuthorModel> list = authorD.getAllAuthors();
		request.setAttribute("authorList", list);
		String jspPage = "/WEB-INF/AuthorTable.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}