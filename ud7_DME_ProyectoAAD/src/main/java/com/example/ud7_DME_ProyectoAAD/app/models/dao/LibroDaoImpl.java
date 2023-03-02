package com.example.ud7_DME_ProyectoAAD.app.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.ud7_DME_ProyectoAAD.app.models.entity.Libro;

import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LibroDaoImpl implements ILibroDao {
	
	@jakarta.persistence.PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Libro> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Libro").getResultList();
	}

	@Override
	@Transactional
	public void save(Libro libro) {
		Long valLong = null;
		if (libro.getId() != valLong && libro.getId() > 0) {
			em.merge(libro);
		} else {
			em.persist(libro);
		}
	}
	
	@Transactional(readOnly = true)
	@Override
	public Libro findOne(long id) {
		// TODO Auto-generated method stub
		return em.find(Libro.class, id);
	}

	@Override
	@Transactional
	public void delete(long id) {
		em.remove(findOne(id));
	}

}
