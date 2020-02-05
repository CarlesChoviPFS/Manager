package com.sprhib.interfaces;

import java.util.List;

import com.sprhib.model.Jugador;

public interface JugadorDAO {
	
	public void addJugador(Jugador jugador);
	public void updateJugador(Jugador jugador);
	public Jugador getJugador(int id);
	public void deleteJugador(int id);
	public List<Jugador> getJugadores();
	public List<Jugador> getJugadoresEquipo(int id);
}
