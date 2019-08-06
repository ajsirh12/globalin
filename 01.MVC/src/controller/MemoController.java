package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemoDAO;
import dao.MemoDAOImpl;
import model.Memo;
import page.PageManager;
import page.PageSQL;

@WebServlet(name = "MemoController", urlPatterns = {"/memo_input", "/memo_save", "/memo_list", "/memo_detail", "/memo_update",
		"/memo_delete", "/memo_save2", "/memo_scan", "/memo_search", "/memo_req_list"})
public class MemoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet() »£√‚µ ");
		
		/*RequestDispatcher rd = req.getRequestDispatcher("/jsp/memo/memoForm.jsp");
		rd.forward(req, resp);*/
		process(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("doPost() »£√‚µ ");
		/*req.setCharacterEncoding("utf-8");
		
		MemoDAO memoDAO = new MemoDAOImpl();
		Memo memo = new Memo();
		memo.setName(req.getParameter("name"));
		memo.setAge(Integer.parseInt(req.getParameter("age")));
		
		boolean result = memoDAO.insert(memo);
		System.out.println(result);*/
		process(req,resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		if(action.equals("memo_input")) {
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/memo/memoForm.jsp");
			rd.forward(req, resp);
		}
		else if(action.equals("memo_save")) {
			MemoDAO memoDAO = new MemoDAOImpl();
			Memo memo = new Memo();
			memo.setName(req.getParameter("name"));
			memo.setAge(Integer.parseInt(req.getParameter("age")));
			
			boolean result = memoDAO.insert(memo);
			System.out.println(result);
			/*RequestDispatcher rd = req.getRequestDispatcher("memo_list");
			rd.forward(req, resp);*/
			resp.sendRedirect("memo_list");
		}
		else if(action.equals("memo_save2")) {
			MemoDAO memoDAO = new MemoDAOImpl();
			Memo memo = new Memo();
			memo.setName(req.getParameter("name"));
			memo.setAge(Integer.parseInt(req.getParameter("age")));
			
			boolean result = memoDAO.insert(memo);
			System.out.println(result);
			/*RequestDispatcher rd = req.getRequestDispatcher("/memo_list");
			rd.forward(req, resp);*/
			resp.sendRedirect("memo_req_list?reqPage=1");
		}
		else if(action.equals("memo_list")) {
			MemoDAO memoDAO = new MemoDAOImpl();
			List<Memo> memoList = memoDAO.selectAll();
			
			//req.getSession().setAttribute("memos", memoList);
			req.setAttribute("memos", memoList);
			/*for(Memo m:memoList) {
				System.out.println(m);
			}*/
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/memo/memoList.jsp");
			rd.forward(req, resp);
		}
		else if(action.equals("memo_detail")) {
			int memoid = Integer.parseInt(req.getParameter("memoid"));
			MemoDAO memoDAO = new MemoDAOImpl();
			Memo memo = memoDAO.selectByMemoId(memoid);
			
			//System.out.println(memo);
			
			req.setAttribute("memo", memo);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/memo/memoDetail.jsp");
			rd.forward(req, resp);
		}
		
		else if(action.equals("memo_update")) {
			MemoDAO memoDAO = new MemoDAOImpl();
			
			Memo memo = new Memo();
			memo.setMemoid(Integer.parseInt(req.getParameter("memoid")));
			memo.setName(req.getParameter("name"));
			memo.setAge(Integer.parseInt(req.getParameter("age")));
			
			boolean result = memoDAO.update(memo);
			System.out.println(memo);
			System.out.println(result);
			
			/*RequestDispatcher rd = req.getRequestDispatcher("/memo_list");
			rd.forward(req, resp);*/
			resp.sendRedirect("memo_list");
		}
		else if(action.equals("memo_delete")) {
			MemoDAO memoDAO = new MemoDAOImpl();
			int memoid = Integer.parseInt(req.getParameter("memoid"));
			boolean result = memoDAO.deleteByMemoId(memoid);
			
			System.out.println(result);
			
			/*RequestDispatcher rd = req.getRequestDispatcher("/memo_list");
			rd.forward(req, resp);*/
			resp.sendRedirect("memo_list");
		}
		else if(action.equals("memo_search")) {
			String name = req.getParameter("name");
			MemoDAO memoDAO = new MemoDAOImpl();
			List<Memo> memoList = memoDAO.selectByName(name);
			
			for(Memo m:memoList) {
				System.out.println(m);
			}
			
			req.setAttribute("memos", memoList);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/memo/memoList.jsp");
			rd.forward(req, resp);
		}
		else if(action.equals("memo_req_list")) {
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			
			PageManager pm = new PageManager(requestPage);
			req.setAttribute("pageGroupResult", pm.getPageGroupResult(PageSQL.MEMO_SELECT_ALL_COUNT));
			
			MemoDAO memoDAO = new MemoDAOImpl();
			List<Memo> memolist = memoDAO.selectAll(pm.getPageRowResult().getRowStartNumber(), pm.getPageRowResult().getRowEndNumber());
			
			req.setAttribute("memos", memolist);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/memo/memoList.jsp");
			rd.forward(req, resp);
		}
	}
	
	
}
