package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.info;
import DAO.infoDAO;
import DAO.impl.infoDAOimpl;

/**
 * Servlet implementation class infoUpdate
 */
@WebServlet("/infoUpdate")
public class infoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public infoUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		info a_info = new info();
		a_info.setId(id);
		a_info.setName(name);
		a_info.setGender(gender);
		a_info.setAge(age);
		a_info.setAddress(address);
		infoDAO infoDao = new infoDAOimpl();
		if (infoDao.update(a_info)) {
			response.sendRedirect("./Admin/infoManager/infoManager.jsp");
		} else {
			response.sendRedirect("./Admin/infoManager/infoUpdate.jsp");
		}
		System.out.print("Edit Success!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
