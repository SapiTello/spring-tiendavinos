package com.tiendavinos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiendavinos.service.ProductoService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private final Logger log= LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private  ProductoService productoService;
	
	@GetMapping("")
	public String home(Model model) {
		
		model.addAttribute("productos",productoService.findAll());
		
		return "usuario/home";
	}
	
	@GetMapping("productohome/{idProducto}")
	public String productoHome(@PathVariable Integer idProducto) {
		log.info("Id producto enviado como parametro {}",idProducto);
		return "usuario/productohome";
	}

}
