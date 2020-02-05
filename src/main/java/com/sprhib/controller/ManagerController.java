package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Manager;
import com.sprhib.service.ManagerService;

@Controller
@RequestMapping(value="/Manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView logManagerPage() {
		ModelAndView modelAndView = new ModelAndView("log-manager-form");
		modelAndView.addObject("manager", new Manager());
		return modelAndView;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView logingManager(@ModelAttribute Manager manager) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		Manager manLog = managerService.getLogManager(manager.getUsuario());
		if(manLog != null) {
			if(manLog.getContr().equals(manager.getContr())){
				String message = "Manager "+manLog.getNombre()+" logueado correctamente.";
				modelAndView.addObject("id", manLog.getId());
				modelAndView.addObject("message", message);
			}
		}else {
			String message = "Error al entrar.";
			modelAndView.addObject("message", message);
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addManagerPage() {
		ModelAndView modelAndView = new ModelAndView("add-manager-form");
		modelAndView.addObject("manager", new Manager());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public ModelAndView addingManager(@ModelAttribute Manager manager) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		Manager manLog = managerService.getLogManager(manager.getUsuario());
		if(manLog == null) {
			managerService.addManager(manager);
			String message = "Manager "+manLog.getNombre()+" insertado correctamente.";
			modelAndView.addObject("message", message);	
		}else {
			String message = "Usuario ya registrado.";
			modelAndView.addObject("message", message);
		}
		return modelAndView;
	}
	
	
	@RequestMapping(value="/list")
	public ModelAndView listOfManagers() {
		ModelAndView modelAndView = new ModelAndView("list-of-managers");
		
		List<Manager> managers = managerService.getManagers();
		modelAndView.addObject("managers", managers);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editManagerPage(@PathVariable Integer id) {
	
		ModelAndView modelAndView = new ModelAndView("edit-manager-form");
		Manager manager = managerService.getManager(id);
		modelAndView.addObject("manager", manager);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingManager(@ModelAttribute Manager manager, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		Manager manLog = managerService.getLogManager(manager.getUsuario());
		if(manLog == null) {
			managerService.updateManager(manager);
			String message = "Manager editado correctamente.";
			modelAndView.addObject("message", message);
		}else {
			String message = "Error, el usuario "+manLog.getUsuario()+" ya está creado.";
			modelAndView.addObject("message", message);
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteManager(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		managerService.deleteManager(id);
		System.out.println("Manager borrado: "+managerService.getManager(id));
		String message = "Manager ha sido borrado correctamente";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
