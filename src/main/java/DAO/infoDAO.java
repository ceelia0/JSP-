package DAO;

import java.util.List;

import Bean.info;

public interface infoDAO {
	public List<info> getAll();

	public info getById(int id);

	public boolean update(info a_info);

	public boolean delete(info a_info);

	public boolean insert(info a_info);
}
