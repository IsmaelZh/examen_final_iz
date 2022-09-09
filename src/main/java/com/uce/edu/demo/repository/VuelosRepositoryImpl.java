package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Vuelo;
import com.uce.edu.demo.modelo.VueloSencillo;

@Repository
@Transactional
public class VuelosRepositoryImpl implements IVueloRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void ingresar(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vuelo);

	}

	@Override
	public List<VueloSencillo> buscarVuelos(String origen, String destino, LocalDateTime fechaVuelo) {
		// TODO Auto-generated method stub
		TypedQuery<VueloSencillo> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.modelo.VueloSencillo (v.numero, v.origen, v.destino, v.avion.nombre, v.valorAsiento) FROM Vuelo v WHERE v.origen = :origen AND v.destino = :destino AND v.fechaVuelo = :fechaVuelo",
				VueloSencillo.class);
		myQuery.setParameter("origen", origen);
		myQuery.setParameter("destino", destino);
		myQuery.setParameter("fechaVuelo", fechaVuelo);
		return myQuery.getResultList();
	}

	@Override
	public Vuelo buscaVueloDisponibles(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Vuelo> myQuery = this.entityManager.createQuery("SELECT Vuelo v FROM v WHERE v.numero = :numero", Vuelo.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

}
