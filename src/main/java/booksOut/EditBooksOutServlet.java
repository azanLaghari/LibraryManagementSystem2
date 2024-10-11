package booksOut;

import java.io.IOException;
import java.sql.SQLException;
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


/**
 * Servlet implementation class EditBooksOutServlet
 */
@WebServlet("/EditBooksOutServlet")
public class EditBooksOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBooksOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	MembersDao membersD = new MembersDao();
		List<MembersModel> member = membersD.getAllMembers();
		
		BookDao bookD = new BookDao();
		List<BooksModel> book = bookD.getAllBooks();
		
		LibrarianDao librarianD = new LibrarianDao();
		List<LibrarianModel> librarian = librarianD.getAllLibrarian();
		
		AuthorDao autherDao = new AuthorDao(); 
    	List<AuthorModel> authors = autherDao.getAllAuthors();
    	
    	BookOutDao bookDao = new BookOutDao();
    	BooksOutModel booksOut = bookDao.selectBooksOutById(Integer.parseInt(request.getParameter("id")));
   		request.setAttribute("booksOut",booksOut);
   		String jspPage = "/WEB-INF/UpdateBooksOut.jsp";
   		request.setAttribute("librarians", librarian);
		request.setAttribute("books",book);
		request.setAttribute("members",member);
		request.setAttribute("authors", authors);
		
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
 		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		BookOutDao bookOutDao = new BookOutDao(); 
        
        String id=request.getParameter("id");
        String bookId=request.getParameter("bookId");  
        String memberId=request.getParameter("memberId");  
        String authorId=request.getParameter("authorId");
        String dateOfOut=request.getParameter("dateOfOut");
        String dateOfReturn=request.getParameter("dateOfReturn");
        String librarianId=request.getParameter("librarianId");

        BooksOutModel booksOut = new BooksOutModel();  
        booksOut.setId(Integer.parseInt(id));  
        booksOut.setBookId(bookId);  
        booksOut.setMemberId(memberId);   
        booksOut.setAuthorId(authorId);
        booksOut.setDateOfOut(dateOfOut);
        booksOut.setDateOfReturn(dateOfReturn);
        booksOut.setLibrarianId(librarianId);
	        
	          
	        try {
	        	bookOutDao.updateBooksOut(booksOut);
	        	
	        	response.sendRedirect("booksOutList");
		        
			} catch (SQLException e1) {
				e1.printStackTrace();
			}  	        
}
} 
