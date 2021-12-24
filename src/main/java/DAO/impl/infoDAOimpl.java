package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.info;
import Bean.user;
import DAO.infoDAO;
import utils.JDBCUtils;

public class infoDAOimpl implements infoDAO {

	@Override
	public List<info> getAll() {
		final String STMT = "SELECT * FROM emInfo";
		List<info> infos = new ArrayList<info>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(STMT);
			rs = ps.executeQuery();
			while (rs.next()) {
				info a_info = new info();
				a_info.setId(rs.getInt("emId"));
				a_info.setName(rs.getString("emName"));
				a_info.setGender(rs.getString("emGen"));
				a_info.setAge(rs.getInt("emAge"));
				a_info.setAddress(rs.getString("emAddress"));
				infos.add(a_info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConn(rs, ps, conn);
		}

		return infos;
	}

	@Override
	public info getById(int id) {
		info a_info = new info();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("SELECT * FROM emInfo WHERE emId=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				a_info.setId(rs.getInt("emId"));
				a_info.setName(rs.getString("emName"));
				a_info.setGender(rs.getString("emGen"));
				a_info.setAge(rs.getInt("emAge"));
				a_info.setAddress(rs.getString("emAddress"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConn(rs, ps, conn);
		}
		return a_info;
	}

	@Override
	public boolean update(info a_info) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("UPDATE emInfo SET emName=?,emGen=?,emAge=?,emAddress=? WHERE emId=?");
			ps.setString(1, a_info.getName());
			ps.setString(2, a_info.getGender());
			ps.setInt(3, a_info.getAge());
			ps.setString(4, a_info.getAddress());
			ps.setInt(5, a_info.getId());
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
	public boolean delete(info a_info) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("DELETE FROM emInfo WHERE emId=?");
			ps.setInt(1, a_info.getId());
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
	public boolean insert(info a_info) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("INSERT INTO emInfo(emId,emName,emGen,emAge,emAddress) VALUES(?,?,?,?,?)");
			ps.setInt(1, a_info.getId());
			ps.setString(2, a_info.getName());
			ps.setString(3, a_info.getGender());
			ps.setInt(4, a_info.getAge());
			ps.setString(5, a_info.getAddress());
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
