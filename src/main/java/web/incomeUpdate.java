package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.income;
import Bean.info;
import DAO.incomeDAO;
import DAO.infoDAO;
import DAO.impl.incomeDAOimpl;
import DAO.impl.infoDAOimpl;

/**
 * Servlet implementation class incomeUpdate
 */
@WebServlet("/incomeUpdate")
public class incomeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public incomeUpdate() {
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
		Double min = Double.parseDouble(request.getParameter("min"));
		Double merit = Double.parseDouble(request.getParameter("merit"));
		Double allo = Double.parseDouble(request.getParameter("allo"));
		Double ponins = Double.parseDouble(request.getParameter("ponins"));
		Double heains = Double.parseDouble(request.getParameter("heains"));
		income a_income = new income();
		a_income.setId(id);
		a_income.setMin(min);
		a_income.setMerit(merit);
		a_income.setAllo(allo);
		a_income.setPonins(ponins);
		a_income.setHeains(heains);
		incomeDAO incomeDao = new incomeDAOimpl();
		if (incomeDao.update(a_income)) {
			response.sendRedirect("./Admin/incomeManager/incomeManager.jsp");
		} else {
			response.sendRedirect("./Admin/incomeManager/incomeUpdate.jsp");
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
