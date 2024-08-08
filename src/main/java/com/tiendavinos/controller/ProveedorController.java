package com.tiendavinos.controller;

import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiendavinos.model.Proveedor;
import com.tiendavinos.service.ProveedorService;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProveedorController.class);
	
	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("proveedores", proveedorService.findAll());
		return "proveedores/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "proveedores/create";
	}
	
	@PostMapping("/save")
    public String save(Proveedor proveedor) {
        LOGGER.info("Este es el objeto proveedor {}", proveedor);
        proveedorService.save(proveedor);
        return "redirect:/proveedores";
    }
	
	@GetMapping("/edit/{idProveedor}")
    public String edit(@PathVariable("idProveedor") Integer idProveedor, Model model) {
        Proveedor proveedor = new Proveedor();
        Optional<Proveedor> optionalProveedor = proveedorService.get(idProveedor);
        proveedor= optionalProveedor.get();
        model.addAttribute("proveedor", proveedor);
		return "proveedores/edit";
    }
	
	@PostMapping("/update/{idProveedor}")
	public String update(@PathVariable("idProveedor") Integer idProveedor, @ModelAttribute("proveedor") Proveedor proveedor, Model model) {
	    Optional<Proveedor> optionalProveedor = proveedorService.get(idProveedor);
	    if (optionalProveedor.isPresent()) {
	        Proveedor proveedordb = optionalProveedor.get();
	        
	        // Actualiza los campos del proveedor
	        proveedordb.setNombre(proveedor.getNombre());
	        proveedordb.setEmail(proveedor.getEmail());
	        proveedordb.setTelefono(proveedor.getTelefono());
	        
	        // Guarda el proveedor actualizado
	        proveedorService.save(proveedordb);
	        
	        // Redirige a la lista de proveedores
	        return "redirect:/proveedores";
	    } else {
	        // Agrega un mensaje de error al modelo y redirige a una página de error
	        model.addAttribute("error", "Proveedor no encontrado");
	        return "error"; // Asegúrate de que esta vista existe
	    }
		
	}
	
	
	
	@GetMapping("/delete/{idProveedor}")
    public String delete(@PathVariable("idProveedor") Integer idProveedor) {
        Optional<Proveedor> optionalProveedor = proveedorService.get(idProveedor);
        if (optionalProveedor.isPresent()) {
            proveedorService.delete(idProveedor);
        }
        return "redirect:/proveedores";
    }

}
