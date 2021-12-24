package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.user;
import DAO.userDAO;
import DAO.impl.userDAOimpl;

/**
 * Servlet implementation class userUpdate
 */
@WebServlet("/userUpdate")
public class userUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public userUpdate() {
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
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		int role = Integer.parseInt(request.getParameter("role"));
		user a_user = new user();
		a_user.setId(id);
		a_user.setAccount(uname);
		a_user.setPasswd(upass);
		a_user.setRole(role);
		userDAO userDao = new userDAOimpl();
		if (userDao.update(a_user)) {
			response.sendRedirect("./Admin/userManager/userManager.jsp");
		} else {
			response.sendRedirect("./Admin/userManager/userUpdate.jsp");
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
