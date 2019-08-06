package dao;

import java.util.List;

import model.Memo;

public interface MemoDAO {
	List<Memo> selectAll();
	List<Memo> selectByName(String name);
	List<Memo> selectAll(int rowStartNumber, int rowEndNumber);
	
	Memo selectByMemoId(int memoid);
	
	boolean insert(Memo memo);
	boolean update(Memo memo);
	boolean deleteByMemoId(int memoid);
}
