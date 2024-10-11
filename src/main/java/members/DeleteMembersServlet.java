package members;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import members.MembersDao;


/**
 * Servlet implementation class DeleteMembersServlet
 */
@WebServlet("/DeleteMembersServlet")
public class DeleteMembersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMembersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MembersDao membersDao = new MembersDao();
		String memberId = request.getParameter("memberId");
		
		 boolean deleted;
		try {
			
			deleted = membersDao.deleteMember(Integer.parseInt(memberId));
		
			 if (deleted) {
		            request.setAttribute("message", "Record deleted successfully");
		        } else {
		            request.setAttribute("error", "Failed to delete record");
		        }
			 response.sendRedirect("membersList");
			 
		} catch (Exception e) {
			
			e.printStackTrace();
        }
	}
	
	


	}
