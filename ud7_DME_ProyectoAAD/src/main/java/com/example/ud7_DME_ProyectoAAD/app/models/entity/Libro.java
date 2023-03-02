package com.example.ud7_DME_ProyectoAAD.app.models.entity;

import javax.validation.constraints.NotEmpty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "libros")
public class Libro {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty
	private String titulo;
	
	@NotEmpty
	private String autor;
	
	@NotEmpty
	private int paginas;
}
