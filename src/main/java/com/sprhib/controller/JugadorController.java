package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Jugador;
import com.sprhib.service.JugadorService;

@Controller
@RequestMapping(value="/Jugador")
public class JugadorController {
	
	@Autowired
	private JugadorService jugadorService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addJugadorPage() {
		ModelAndView modelAndView = new ModelAndView("add-jugador-form");
		modelAndView.addObject("jugador", new Jugador());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public ModelAndView addingJugador(@ModelAttribute Jugador jugador) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		jugadorService.addJugador(jugador);
		
		String message = "Jugador insertado correctamente.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	
	@RequestMapping(value="/list")
	public ModelAndView listOfJugadores() {
		ModelAndView modelAndView = new ModelAndView("list-of-jugadores");
		
		List<Jugador> jugadores = jugadorService.getJugadores();
		modelAndView.addObject("jugadores", jugadores);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editJugadorPage(@PathVariable Integer id) {
	
		ModelAndView modelAndView = new ModelAndView("edit-jugador-form");
		Jugador jugador = jugadorService.getJugador(id);
		modelAndView.addObject("jugador", jugador);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingJugador(@ModelAttribute Jugador jugador, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		jugadorService.updateJugador(jugador);
		
		String message = "Jugador editado correctamente.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteJugador(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		jugadorService.deleteJugador(id);
		String message = "Jugador ha sido borrado correctamente";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
