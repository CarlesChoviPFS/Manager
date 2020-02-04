package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Manager;
import com.sprhib.interfaces.ManagerDAO;

@Repository
public class ManagerDAOImpl implements ManagerDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addManager(Manager manager) {
		getCurrentSession().save(manager);
		
	}

	public void updateManager(Manager manager) {
		Manager managerToUpdate = getManager(manager.getId());
		managerToUpdate.setNombre(manager.getNombre());
		managerToUpdate.setApellidos(manager.getApellidos());
		managerToUpdate.setUsuario(manager.getUsuario());
		managerToUpdate.setContr(manager.getContr());
		getCurrentSession().update(managerToUpdate);
		
	}

	public Manager getManager(int id) {
		Manager manager = (Manager) getCurrentSession().get(Manager.class, id);
		return manager;
	}

	public void deleteManager(int id) {
		Manager manager = getManager(id);
		if(manager != null) {
			getCurrentSession().delete(manager);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Manager> getManagers() {
		return getCurrentSession().createQuery("from Manager").list();
	}

}
