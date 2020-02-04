package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Jugador;

public interface JugadorService {
	
	public void addJugador(Jugador jugador);
	public void updateJugador(Jugador jugador);
	public Jugador getJugador(int id);
	public void deleteJugador(int id);
	public List<Jugador> getJugadores();

}
