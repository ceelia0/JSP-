package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.user;
import DAO.userDAO;
import utils.JDBCUtils;

public class userDAOimpl implements userDAO {

	@Override
	public List<user> getAll() {
		final String STMT = "SELECT * FROM emUsers";
		List<user> users = new ArrayList<user>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(STMT);
			rs = ps.executeQuery();
			while (rs.next()) {
				user a_user = new user();
				a_user.setId(rs.getInt("emId"));
				a_user.setAccount(rs.getString("emAccount"));
				a_user.setPasswd(rs.getString("emPasswd"));
				a_user.setRole(rs.getInt("emRole"));
				users.add(a_user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConn(rs, ps, conn);
		}

		return users;
	}

	@Override
	public user getById(int id) {
		user a_user = new user();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("SELECT * FROM emUsers WHERE emId=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				a_user.setId(rs.getInt("emId"));
				a_user.setAccount(rs.getString("emAccount"));
				a_user.setPasswd(rs.getString("emPasswd"));
				a_user.setRole(rs.getInt("emRole"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConn(rs, ps, conn);
		}
		return a_user;
	}

	@Override
	public user getByName(String uname) {
		user a_user = new user();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("SELECT * FROM emUsers WHERE emAccount=?");
			ps.setString(1, uname);
			rs = ps.executeQuery();
			while (rs.next()) {
				a_user.setId(rs.getInt("emId"));
				a_user.setAccount(rs.getString("emAccount"));
				a_user.setPasswd(rs.getString("emPasswd"));
				a_user.setRole(rs.getInt("emRole"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConn(rs, ps, conn);
		}
		return a_user;
	}

	@Override
	public boolean update(user a_user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("UPDATE emUsers SET emAccount=?,emPasswd=?,emRole=? WHERE emId=?");
			ps.setString(1, a_user.getAccount());
			ps.setString(2, a_user.getPasswd());
			ps.setInt(3, a_user.getRole());
			ps.setInt(4, a_user.getId());
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
	public boolean delete(user a_user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("DELETE FROM emUsers WHERE emId=?");
			ps.setInt(1, a_user.getId());
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

	public boolean insert(user a_user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("INSERT INTO emUsers(emId,emAccount,emPasswd,emRole) VALUES(?,?,?,?)");
			ps.setInt(1, a_user.getId());
			ps.setString(2, a_user.getAccount());
			ps.setString(3, a_user.getPasswd());
			ps.setInt(4, a_user.getRole());
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
