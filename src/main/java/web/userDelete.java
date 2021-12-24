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
 * Servlet implementation class userDelete
 */
@WebServlet("/userDelete")
public class userDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public userDelete() {
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
		if (userDao.delete(a_user)) {
			System.out.print("Delete Success!");
			response.sendRedirect("./Admin/userManager/userManager.jsp");
		} else {
			System.out.print("Delete Failed!");
		}
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
