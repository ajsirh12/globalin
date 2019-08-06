package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import dao.BookDAOImpl;
import model.Book;

@WebServlet(name = "BookController", urlPatterns = {"/bookinput", "/select_book", "/book_list"})
public class BookController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}


	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		if(action.equals("bookinput")) {
			BookDAO bookDAO = new BookDAOImpl();
			String publisher = req.getParameter("publisher");
			List<Book> books = bookDAO.selectByPublisher(publisher);
			
			/*for(Book b:books) {
				System.out.println(b);
			}*/
			
			req.setAttribute("books", books);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/book/bookInput.jsp");
			rd.forward(req, resp);
		}
		if(action.equals("select_book")) {
			req.setCharacterEncoding("utf-8");
			
			BookDAO bookDAO = new BookDAOImpl();
			Book book = new Book();
			book.setBookname(req.getParameter("bookname"));
			book.setPublisher(req.getParameter("publisher"));
			book.setPrice(Integer.parseInt(req.getParameter("price")));
			
			boolean result = bookDAO.insert(book);
			System.out.println(result);
			
			RequestDispatcher rd = req.getRequestDispatcher("/book_list");
			rd.forward(req, resp);
		}
		if(action.equals("book_list")) {
			BookDAO bookDAO = new BookDAOImpl();
			List<Book> books = bookDAO.selectAll();
			
			for(Book b:books) {
				System.out.println(b);
			}
			req.setAttribute("books", books);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/book/bookList.jsp");
			rd.forward(req, resp);
		}
	}
	
}
