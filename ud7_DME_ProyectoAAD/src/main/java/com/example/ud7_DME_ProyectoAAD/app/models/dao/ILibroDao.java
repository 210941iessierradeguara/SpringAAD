package com.example.ud7_DME_ProyectoAAD.app.models.dao;

import java.util.List;

import com.example.ud7_DME_ProyectoAAD.app.models.entity.Libro;

public interface ILibroDao {
	
	public List<Libro> findAll();
	
	public void save(Libro libro);
	
	public Libro findOne(long id);
	
	public void delete(long id);	
}