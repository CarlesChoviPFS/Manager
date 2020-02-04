package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Jugador;
import com.sprhib.interfaces.JugadorDAO;

@Repository
public class JugadorDAOImpl  implements JugadorDAO{
	
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addJugador(Jugador jugador) {
		getCurrentSession().save(jugador);
		
	}

	public void updateJugador(Jugador jugador) {
		Jugador jugadorToUpdate = getJugador(jugador.getDorsal());
		jugadorToUpdate.setNombre(jugador.getNombre());
		jugadorToUpdate.setApellidos(jugador.getApellidos());
		jugadorToUpdate.setEdad(jugador.getEdad());
		jugadorToUpdate.setPosicion(jugador.getPosicion());
		jugadorToUpdate.setAltura(jugador.getAltura());
		jugadorToUpdate.setPeso(jugador.getPeso());
		
	}

	public Jugador getJugador(int id) {
		Jugador jugador = (Jugador) getCurrentSession().get(Jugador.class, id);
		return jugador;
	}

	public void deleteJugador(int id) {
		Jugador jugador = getJugador(id);
		if(jugador != null) {
			getCurrentSession().delete(id);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Jugador> getJugadores() {
		return getCurrentSession().createQuery("from Jugador").list();
	}

}
