package booksOut;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import author.AuthorDao;
import author.AuthorModel;
import books.BookDao;
import books.BooksModel;
import librarian.LibrarianDao;
import librarian.LibrarianModel;
import members.MembersDao;
import members.MembersModel;




@WebServlet("/RegisterBooksOutServlet")
public class RegisterBooksOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public RegisterBooksOutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		MembersDao membersD = new MembersDao();
		List<MembersModel> member = membersD.getAllMembers();
		
		BookDao bookD = new BookDao();
		List<BooksModel> book = bookD.getAllBooks();
		
		LibrarianDao librarianD = new LibrarianDao();
		List<LibrarianModel> librarian = librarianD.getAllLibrarian();
		
		AuthorDao autherDao = new AuthorDao(); 
    	List<AuthorModel> authors = autherDao.getAllAuthors();
    	
		String jspPage = "/WEB-INF/RegisterBooksOut.jsp";
		request.setAttribute("authors", authors);
		request.setAttribute("librarians", librarian);
		request.setAttribute("books",book);
		request.setAttribute("members",member);
		
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
        dispatcher.forward(request, response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 
			try {
			BooksOutModel book = new BooksOutModel();
			
			 book.setBookId(request.getParameter("bookId"));
			 book.setMemberId(request.getParameter("memberId"));
			 book.setAuthorId(request.getParameter("authorId"));
			 book.setDateOfOut(request.getParameter("dateOfOut"));
			 book.setDateOfReturn(request.getParameter("dateOfReturn"));
			 book.setLibrarianId(request.getParameter("librarianId"));
			
			
			 BookOutDao bookOutDao = new BookOutDao();
			 bookOutDao.addBooksOut(book);
			
			response.sendRedirect("booksOutList");
			
			 } catch (Exception e) {
			       
			        e.printStackTrace();
			        
			        response.sendRedirect("errorPage.jsp");
			    }
			}
}