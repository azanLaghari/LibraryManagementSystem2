package members;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RegisterMembersServlet
 */
@WebServlet("/RegisterMembersServlet")
public class RegisterMembersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterMembersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jspPage = "/WEB-INF/RegisterMembers.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
        dispatcher.forward(request, response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 
			try {
		    MembersModel members = new MembersModel();
		    members.setFirstName(request.getParameter("firstName"));
		    members.setLastName(request.getParameter("lastName"));
		    members.setDateOfBirth(request.getParameter("dateOfBirth"));
			
			
			MembersDao membersDao = new MembersDao();
			membersDao.addMembers(members);
			
			response.sendRedirect("membersList");
			
			 } catch (Exception e) {
			       
			        e.printStackTrace();
			        
			        response.sendRedirect("errorPage.jsp");
			    }
			}
}
