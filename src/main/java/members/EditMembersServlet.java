package members;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//import members.MembersDao;
//import members.MembersModel;

/**
 * Servlet implementation class EditMembersServlet
 */
@WebServlet("/EditMembersServlet")
public class EditMembersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
          /**
     * @see HttpServlet#HttpServlet()
     */
	public EditMembersServlet() {
        super();
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	MembersDao membersDao = new MembersDao();
    	MembersModel members = membersDao.selectMembersById(Integer.parseInt(request.getParameter("memberId")));
   		request.setAttribute("members", members);
   		String jspPage = "/WEB-INF/UpdateMembers.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
 		dispatcher.forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     MembersDao  memberDao = new  MembersDao(); 
	       
		    String memberId=request.getParameter("memberId");
	        String firstName=request.getParameter("firstName");  
	        String lastName=request.getParameter("lastName");  
	        String dateOfBirth=request.getParameter("dateOfBirth"); 
//	        String membershipStartDate=request.getParameter("membershipStartDate"); 
//	        String membershipEndDate=request.getParameter("membershipEndDate"); 
	
	        MembersModel  member = new  MembersModel ();  
	        member.setMemberId(Integer.parseInt(memberId));  
	        member.setFirstName(firstName);  
	        member.setLastName(lastName);  
	        member.setDateOfBirth(dateOfBirth); 
//	        member.setMembershipStartDate(membershipStartDate); 
//	        member.setMemberShipEndDate(membershipEndDate); 
	        
	          
	        try {
	        	memberDao.updateMember(member);
	        	
	        	response.sendRedirect("membersList");
		        
			} catch (SQLException e1) {
				e1.printStackTrace();
			}  	        
}
} 