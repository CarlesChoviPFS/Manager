package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Manager;

public interface ManagerService {
	
	public void addManager(Manager manager);
	public void updateManager(Manager manager);
	public Manager getManager(int id);
	public void deleteManager(int id);
	public List<Manager> getManagers();

}
