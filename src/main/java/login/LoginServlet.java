package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jspPage = "/WEB-INF/Login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		LoginDao loginDao = new LoginDao();
		boolean status = loginDao.validate(userName, password);

		if (!status) {

			String loginPage = "/WEB-INF/Login.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(loginPage);
			request.setAttribute("error", "Invalid username or password");
			dispatcher.forward(request, response);

		} else if (status) {

			String dashBoradPage = "/WEB-INF/DashBorad.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(dashBoradPage);
			request.setAttribute("successfully", dispatcher);
			dispatcher.forward(request, response);
		}
	}
}