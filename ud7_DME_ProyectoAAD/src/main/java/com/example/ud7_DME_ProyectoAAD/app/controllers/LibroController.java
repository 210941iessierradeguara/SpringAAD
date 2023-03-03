package com.example.ud7_DME_ProyectoAAD.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

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
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Libro libro, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("encabezado", "Formulario del Libro");
			return "form";
		}
		
		iLibroDao.save(libro);
		status.setComplete();
		return "redirect:listar";
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Libro libro = null;
		
		if(id > 0) {
			libro = iLibroDao.findOne(id);
		} else {
			return "redirect:/listar";
		}
		model.put("libro", libro);
		model.put("encabezado", "Editar Libro");
		return "form";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id > 0) {
			iLibroDao.delete(id);
		}
		return "redirect:/listar";
	}
}
