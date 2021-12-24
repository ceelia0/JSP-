package DAO;

import java.util.List;

import Bean.income;

public interface incomeDAO {
	public List<income> getAll();

	public income getById(int id);

	public boolean update(income a_income);

	public boolean delete(income a_income);

	public boolean insert(income a_income);
}
