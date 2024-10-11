package booksOut;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booksOut.BookOutDao;


/**
 * Servlet implementation class DeleteBooksOutServlet
 */
@WebServlet("/DeleteBooksOutServlet")
public class DeleteBooksOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBooksOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 BookOutDao  bookOutDao = new  BookOutDao();
		String id = request.getParameter("id");
		
		 boolean deleted;
		try {
			
			deleted = bookOutDao.deleteBooksOut(Integer.parseInt(id));
		
			 if (deleted) {
		            request.setAttribute("message", "Record deleted successfully");
		        } else {
		            request.setAttribute("error", "Failed to delete record");
		        }
			  response.sendRedirect("booksOutList");
		
			 
		} catch (Exception e) {
			
			e.printStackTrace();
        }
	}

	}

