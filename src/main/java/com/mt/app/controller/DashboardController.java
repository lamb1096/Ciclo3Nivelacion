package com.mt.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mt.app.entity.Tarea;
import com.mt.app.service.TareaService;

@Controller
@SessionAttributes
public class DashboardController {
	
	@Autowired
	TareaService tareaService;

	@GetMapping()
	public String dashboard(Model model) {
		
		List<Tarea> toDo = tareaService.findByEstado(Long.valueOf(1));
		List<Tarea> doing = tareaService.findByEstado(Long.valueOf(2));
		List<Tarea> done = tareaService.findByEstado(Long.valueOf(3));
		
		model.addAttribute("toDo", toDo);
		model.addAttribute("doing", doing);
		model.addAttribute("done", done);
		model.addAttribute("uno", 1);
		model.addAttribute("dos", 2);
		model.addAttribute("tres", 3);
		
		model.addAttribute("tarea", new Tarea());
		
		return "dashboard";

	}
	
}
