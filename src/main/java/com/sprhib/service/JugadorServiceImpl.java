package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.model.Jugador;
import com.sprhib.interfaces.JugadorDAO;

@Service
@Transactional
public class JugadorServiceImpl implements JugadorService{

	@Autowired
	private JugadorDAO jugadorDAO;
	
	public void addJugador(Jugador jugador) {
		jugadorDAO.addJugador(jugador);
	}

	public void updateJugador(Jugador jugador) {
		jugadorDAO.updateJugador(jugador);
	}

	public Jugador getJugador(int id) {
		return jugadorDAO.getJugador(id);
	}

	public void deleteJugador(int id) {
		jugadorDAO.deleteJugador(id);
	}

	public List<Jugador> getJugadores() {
		return jugadorDAO.getJugadores();
	}

	public List<Jugador> getJugadoresEquipo(int id) {
		return jugadorDAO.getJugadoresEquipo(id);
	}

}
