package dao;

import java.util.List;

import model.Book;

public interface BookDAO {
	List<Book> selectByPublisher(String publisher);
	List<Book> selectAll();
	boolean insert(Book book);
}
