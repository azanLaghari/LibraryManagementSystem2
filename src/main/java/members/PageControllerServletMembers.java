package members;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class PageControllerServletMembers
 */
@WebServlet("/PageControllerServletMembers")
public class PageControllerServletMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageControllerServletMembers() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MembersDao membersD = new MembersDao();
		List<MembersModel> list = membersD.getAllMembers();
	    request.setAttribute("membersList", list);
        String jspPage = "/WEB-INF/MembersTable.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}