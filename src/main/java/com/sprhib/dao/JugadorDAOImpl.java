package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Jugador;
import com.sprhib.interfaces.JugadorDAO;

@Repository
public class JugadorDAOImpl implements JugadorDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addJugador(Jugador jugador) {
		getCurrentSession().save(jugador);
		
	}

	public void updateJugador(Jugador jugador) {
		Jugador jugadorToUpdate = getJugador(jugador.getId());
		jugadorToUpdate.setDorsal(jugador.getDorsal());
		jugadorToUpdate.setNombre(jugador.getNombre());
		jugadorToUpdate.setApellidos(jugador.getApellidos());
		jugadorToUpdate.setAltura(jugador.getAltura());
		jugadorToUpdate.setPeso(jugador.getPeso());
		jugadorToUpdate.setEdad(jugador.getEdad());
		jugadorToUpdate.setPosicion(jugador.getPosicion());
		jugadorToUpdate.setEquipo(jugador.getEquipo());
		getCurrentSession().update(jugadorToUpdate);
		
	}

	public Jugador getJugador(int id) {
		Jugador jugador = (Jugador) getCurrentSession().get(Jugador.class, id);
		return jugador;
	}

	public void deleteJugador(int id) {
		Jugador jugador = getJugador(id);
		if(jugador != null) {
			getCurrentSession().delete(jugador);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Jugador> getJugadores() {
		return getCurrentSession().createQuery("from Jugador").list();

	}

	public List<Jugador> getJugadoresEquipo(int id) {
		String hql ="from Jugador j where j.equipo =:id";
		return getCurrentSession().createQuery(hql).setParameter("id", id).list();
	}

}
