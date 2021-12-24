package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.income;
import Bean.info;
import DAO.incomeDAO;
import utils.JDBCUtils;

public class incomeDAOimpl implements incomeDAO {

	@Override
	public List<income> getAll() {
		final String STMT = "SELECT * FROM emIncome";
		List<income> incomes = new ArrayList<income>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(STMT);
			rs = ps.executeQuery();
			while (rs.next()) {
				income a_income = new income();
				a_income.setId(rs.getInt("emId"));
				a_income.setMin(rs.getDouble("emMin"));
				a_income.setMerit(rs.getDouble("emMerit"));
				a_income.setAllo(rs.getDouble("emAllo"));
				a_income.setPonins(rs.getDouble("emPonins"));
				a_income.setHeains(rs.getDouble("emHeains"));
				incomes.add(a_income);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConn(rs, ps, conn);
		}

		return incomes;
	}

	@Override
	public income getById(int id) {
		income a_income = new income();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("SELECT * FROM emIncome WHERE emId=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				a_income.setId(rs.getInt("emId"));
				a_income.setMin(rs.getDouble("emMin"));
				a_income.setMerit(rs.getDouble("emMerit"));
				a_income.setAllo(rs.getDouble("emAllo"));
				a_income.setPonins(rs.getDouble("emPonins"));
				a_income.setHeains(rs.getDouble("emHeains"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConn(rs, ps, conn);
		}
		return a_income;
	}

	@Override
	public boolean update(income a_income) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(
					"UPDATE emIncome SET emMin=?,emMerit=?,emAllo=?,emPonins=?,emHeains=? WHERE emId=?");
			ps.setDouble(1, a_income.getMin());
			ps.setDouble(2, a_income.getMerit());
			ps.setDouble(3, a_income.getAllo());
			ps.setDouble(4, a_income.getPonins());
			ps.setDouble(5, a_income.getHeains());
			ps.setInt(6, a_income.getId());
			if (ps.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConn(rs, ps, conn);
		}
		return false;
	}

	@Override
	public boolean delete(income a_income) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("DELETE FROM emIncome WHERE emId=?");
			ps.setInt(1, a_income.getId());
			int status = ps.executeUpdate();
			if (status > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConn(rs, ps, conn);
		}
		return false;
	}

	@Override
	public boolean insert(income a_income) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(
					"INSERT INTO emIncome(emId,emMin,emMerit,emAllo,emPonins,emHeains) VALUES(?,?,?,?,?,?)");
			ps.setInt(1, a_income.getId());
			ps.setDouble(2, a_income.getMin());
			ps.setDouble(3, a_income.getMerit());
			ps.setDouble(4, a_income.getAllo());
			ps.setDouble(5, a_income.getPonins());
			ps.setDouble(6, a_income.getHeains());
			int status = ps.executeUpdate();
			if (status > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConn(rs, ps, conn);
		}
		return false;
	}
}
