package com.tiendavinos.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiendavinos.model.Resena;
import com.tiendavinos.repository.IResenaRepository;

@Controller
public class ResenaController {
	
	@Autowired
	private IResenaRepository resenaRepository;
	
	
	@PostMapping("/guardarResena")
	public String guardarResena(@ModelAttribute Resena resena) {
		
		System.out.println("Nombre recibido: " + resena.getNombre());
		//Establece la fecha y hora que hicieron la reseña
		resena.setFecha(LocalDateTime.now());
		
		//Guarda la reseña en BD
		resenaRepository.save(resena);
		return "redirect:/";
		
	}
	

}
