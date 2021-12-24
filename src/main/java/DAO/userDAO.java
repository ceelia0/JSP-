package DAO;

import Bean.user;

import java.util.List;

public interface userDAO {
	public List<user> getAll();

	public user getByName(String uname);

	public user getById(int id);

	public boolean update(user a_user);

	public boolean delete(user a_user);

	public boolean insert(user a_user);
}
