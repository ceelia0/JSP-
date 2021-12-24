package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.user;
import DAO.userDAO;
import DAO.impl.userDAOimpl;
import utils.validate;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
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
		String serverInfo = request.getSession().getServletContext().getServerInfo();
		System.out.println("Server Info " + serverInfo);
		String servletInfo = request.getSession().getServletContext().getMajorVersion() + "."
				+ request.getSession().getServletContext().getMinorVersion();
		System.out.println("Servlet Info " + servletInfo);
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		userDAO user = new userDAOimpl();
		user a_user = new user();
		a_user = user.getByName(uname);
		HttpSession session = request.getSession();
		session.setAttribute("id", a_user.getId());
		if (validate.checkPass(upass, a_user.getPasswd())) {
			if (validate.checkPerm(a_user.getRole())) {
				// admin to webapp/Admin/index.html
				response.sendRedirect("Admin/index.jsp");
			} else {
				// other to webapp/User/index.html
				response.sendRedirect("User/index.jsp");
			}
		} else {
			// no such user
			System.out.print("error");
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
