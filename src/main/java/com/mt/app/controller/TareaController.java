package com.mt.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mt.app.entity.Tarea;
import com.mt.app.service.TareaService;

@Controller
public class TareaController {

	@Autowired
	TareaService tareaService;

	@GetMapping("/eliminar/{id}")
	public String eliminarTarea(@PathVariable Long id) {

		tareaService.deleteById(id);

		return "redirect:/";

	}

	@PostMapping("/crear")
	public String crear(@Valid Tarea tarea, BindingResult bindingResult) {

		tareaService.save(tarea);

		return "redirect:/";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, HttpServletRequest request) {

		Tarea tarea = new Tarea(id, request.getParameter("titulo"), request.getParameter("descripcion"),
				Long.valueOf(request.getParameter("estadoId")));

		tareaService.save(tarea);

		return "redirect:/";
	}

}
