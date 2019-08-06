package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InputController", urlPatterns = {"/input_home", "/input_01", "/input_02", "/input_03", "/select", "/textarea"})
public class InputController extends HttpServlet {

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
		System.out.println(uri);
		
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		
		
		req.setCharacterEncoding("utf-8");
		
		
		if(action.equals("input_home")) {
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/input/inputForm.jsp");
			rd.forward(req, resp);
		}
		else if(action.equals("input_01")) {
			String name = req.getParameter("username");
			String password = req.getParameter("password");
			System.out.println(name + " " + password);
			
			req.setAttribute("name", name);
			req.setAttribute("password", password);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/input/resultForm.jsp");
			rd.forward(req, resp);
		}
		else if(action.equals("input_02")) {
			String gender = req.getParameter("gender");
			System.out.println(gender);
			
			req.setAttribute("gender", gender);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/input/resultForm.jsp");
			rd.forward(req, resp);
		}
		else if(action.equals("input_03")) {
			String[] vehicles = req.getParameterValues("vehicle");
			
			for(String s:vehicles) {
				System.out.println(s);
			}
			req.setAttribute("vehicles", vehicles);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/input/resultForm.jsp");
			rd.forward(req, resp);
		}
		else if(action.equals("select")) {
			//System.out.println(req.getParameter("cars"));
			String cars = req.getParameter("cars");
			System.out.println(cars);
			
			req.setAttribute("cars", cars);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/input/resultForm.jsp");
			rd.forward(req, resp);

		}
		else if(action.equals("textarea")) {
			String message = req.getParameter("message");
			System.out.println(message);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/input/inputForm.jsp");
			rd.forward(req, resp);
		}
	}
}
