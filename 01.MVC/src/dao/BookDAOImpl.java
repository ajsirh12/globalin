package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookDAOImpl extends BaseDAO implements BookDAO {

	private static final String BOOK_SELECT_PUBLISHER_SQL = "select distinct publisher from book";
	private static final String BOOK_SELECT_ALL_SQL = "SELECT bookid, bookname, publisher, price FROM book ORDER BY bookid desc";
	private static final String BOOK_INSERT_SQL = "INSERT INTO book VALUES(SEQ_BOOK.nextval, ?, ?, ?)";
	@Override
	public List<Book> selectByPublisher(String publisher) {
		List<Book> books = new ArrayList<Book>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BOOK_SELECT_PUBLISHER_SQL);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Book book = new Book();
				book.setPublisher(resultSet.getString("publisher"));
				books.add(book);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return books;
	}
	@Override
	public List<Book> selectAll() {
		List<Book> books = new ArrayList<Book>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BOOK_SELECT_ALL_SQL);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Book book = new Book();
				book.setBookid(resultSet.getInt("bookid"));
				book.setBookname(resultSet.getString("bookname"));
				book.setPublisher(resultSet.getString("publisher"));
				book.setPrice(resultSet.getInt("price"));
				books.add(book);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return books;
	}
	@Override
	public boolean insert(Book book) {
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BOOK_INSERT_SQL);
			preparedStatement.setString(1, book.getBookname());
			preparedStatement.setString(2, book.getPublisher());
			preparedStatement.setInt(3, book.getPrice());
			int count = preparedStatement.executeUpdate();
			
			if(count>0) {
				result = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return result;
	}

}
