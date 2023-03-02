package com.example.ud7_DME_ProyectoAAD.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ud7_DME_ProyectoAAD.app.models.dao.ILibroDao;

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
}
