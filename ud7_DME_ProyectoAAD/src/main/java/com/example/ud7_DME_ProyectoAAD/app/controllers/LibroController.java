package com.example.ud7_DME_ProyectoAAD.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ud7_DME_ProyectoAAD.app.models.dao.ILibroDao;
import com.example.ud7_DME_ProyectoAAD.app.models.entity.Libro;

@Controller
@SessionAttributes("libro")
public class LibroController {
	
	@Autowired
	private ILibroDao iLibroDao;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model)
	{
		model.addAttribute("encabezado", "Listado de libros");
		model.addAttribute("libros", iLibroDao.findAll());
		return "listar";
	}
	
	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Libro libro = new Libro();
		model.put("libro", libro);
		model.put("encabezado", "Formulario de Libro");
		return "form";
	}
}
