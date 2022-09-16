package com.academy.shopping.model.admin;

import java.util.List;

import com.academy.shopping.model.domain.Admin;

public interface AdminDAO {
	public List selectAll();
	public Admin select(int admin_id);
	public Admin selectByIdAndPass(Admin admin);
	public void insert(Admin admin);
	public void update(Admin admin);
	public void delete(Admin admin);
	

}
