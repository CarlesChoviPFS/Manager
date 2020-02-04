package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.model.Manager;
import com.sprhib.interfaces.ManagerDAO;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerDAO managerDAO;
	
	public void addManager(Manager manager) {
		managerDAO.addManager(manager);
	}

	public void updateManager(Manager manager) {
		managerDAO.updateManager(manager);
	}

	public Manager getManager(int id) {
		return managerDAO.getManager(id);
	}

	public void deleteManager(int id) {
		managerDAO.deleteManager(id);
	}

	public List<Manager> getManagers() {
		return managerDAO.getManagers();
	}

}
