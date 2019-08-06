package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Memo;
import page.PageManager;
import page.PageRowResult;

public class MemoDAOImpl extends BaseDAO implements MemoDAO {

	private static final String MEMO_INSERT_SQL = "INSERT INTO memo VALUES(SEQ_MEMO.nextval, ?, ?)";
	private static final String MEMO_SELECT_ALL_SQL = "SELECT memoid, name, age FROM memo ORDER BY memoid desc";
	private static final String MEMO_SELECT_MEMOID_SQL = "SELECT memoid, name, age FROM memo WHERE memoid = ?";
	private static final String MEMO_UPDATE_SQL = "UPDATE memo SET name = ?, age = ? WHERE memoid = ?";
	private static final String MEMO_DELETE_SQL = "DELETE FROM memo WHERE memoid = ?";
	private static final String MEMO_SELECT_NAME_SQL = "SELECT memoid, name, age FROM memo WHERE name like ? ORDER BY memoid desc";
	private static final String MEMO_SELECT_PAGE = "SELECT * FROM (SELECT rownum rn, memo.* FROM (SELECT * FROM memo ORDER BY memoid desc) memo) WHERE rn between ? and ?";
	
	@Override
	public boolean insert(Memo memo) {
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_INSERT_SQL);
			preparedStatement.setString(1, memo.getName());
			preparedStatement.setInt(2, memo.getAge());
			int count = preparedStatement.executeUpdate();
			
			if(count > 0) {
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
	@Override
	public List<Memo> selectAll() {
		List<Memo> memos = new ArrayList<Memo>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_SELECT_ALL_SQL);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Memo memo = new Memo();
				memo.setMemoid(resultSet.getInt("memoid"));
				memo.setName(resultSet.getString("name"));
				memo.setAge(resultSet.getInt("age"));
				memos.add(memo);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return memos;
	}
	@Override
	public Memo selectByMemoId(int memoid) {
		Memo memo = new Memo();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_SELECT_MEMOID_SQL);
			preparedStatement.setInt(1, memoid);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				memo.setAge(resultSet.getInt("age"));
				memo.setMemoid(resultSet.getInt("memoid"));
				memo.setName(resultSet.getString("name"));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return memo;
	}
	@Override
	public boolean update(Memo memo) {
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_UPDATE_SQL);
			preparedStatement.setString(1, memo.getName());
			preparedStatement.setInt(2, memo.getAge());
			preparedStatement.setInt(3, memo.getMemoid());
			
			int count = preparedStatement.executeUpdate();
			
			if(count>0) {
				result = true;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		
		return result;
	}
	@Override
	public boolean deleteByMemoId(int memoid) {
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_DELETE_SQL);
			preparedStatement.setInt(1, memoid);
			
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
	@Override
	public List<Memo> selectByName(String name) {
		List<Memo> memos = new ArrayList<Memo>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_SELECT_NAME_SQL);
			preparedStatement.setString(1, "%"+name+"%");
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Memo memo = new Memo();
				memo.setMemoid(resultSet.getInt("memoid"));
				memo.setAge(resultSet.getInt("age"));
				memo.setName(resultSet.getString("name"));
				memos.add(memo);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return memos;
	}
	@Override
	public List<Memo> selectAll(int rowStartNumber, int rowEndNumber) {
		List<Memo> memos = new ArrayList<Memo>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_SELECT_PAGE);
			preparedStatement.setInt(1, rowStartNumber);
			preparedStatement.setInt(2, rowEndNumber);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Memo memo = new Memo();
				memo.setMemoid(resultSet.getInt("memoid"));
				memo.setName(resultSet.getString("name"));
				memo.setAge(resultSet.getInt("age"));
				memos.add(memo);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return memos;
	}

}
