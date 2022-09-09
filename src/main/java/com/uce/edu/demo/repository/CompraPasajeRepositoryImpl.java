package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.CompraPasaje;

@Repository
@Transactional
public class CompraPasajeRepositoryImpl implements ICompraPasajeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CompraPasaje buscarNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<CompraPasaje> myQuery = entityManager
				.createQuery("SELECT cp FROM CompraPasaje cp WHERE cp.numero=:numero", CompraPasaje.class);
		myQuery.setParameter("numero", numero);
		try {
			return myQuery.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public void actualizarCheckIn(CompraPasaje compraPasaje) {
		// TODO Auto-generated method stub
		this.entityManager.merge(compraPasaje);
	}

}
