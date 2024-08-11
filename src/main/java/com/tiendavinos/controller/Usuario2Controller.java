package com.tiendavinos.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiendavinos.model.Usuario;
import com.tiendavinos.service.UsuarioService;

@Controller
@RequestMapping("/usuario2")
public class Usuario2Controller {
	
	private final Logger LOGGER = LoggerFactory.getLogger(Usuario2Controller.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("usuarios", usuarioService.findAll());
		return "usuarios/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "usuarios/create";
	}
	
	@PostMapping("/save")
    public String save(Usuario usuario) {
        LOGGER.info("Este es el objeto usuario {}", usuario);
        usuarioService.save(usuario);
        return "redirect:/usuario2";
    }
	
	@GetMapping("/edit/{idUsuario}")
    public String edit(@PathVariable("idUsuario") Integer idUsuario, Model model) {
        Usuario usuario = new Usuario();
        Optional<Usuario> optionalUsuario= usuarioService.get(idUsuario);
        usuario= optionalUsuario.get();
        model.addAttribute("usuario", usuario);
		return "usuarios/edit";
    }
	
	@PostMapping("/update/{idUsuario}")
	public String update(@PathVariable("idUsuario") Integer idUsuario, @ModelAttribute("usuario") Usuario usuario, Model model) {
	    Optional<Usuario> optionalUsuario = usuarioService.get(idUsuario);
	    if (optionalUsuario.isPresent()) {
	        Usuario usuariodb = optionalUsuario.get();
	        
	        // Actualiza los campos del usuario
	        usuariodb.setNombre(usuario.getNombre());
	        usuariodb.setTipo(usuario.getTipo());
	        usuariodb.setDirección(usuario.getDirección());
	        usuariodb.setEmail(usuario.getEmail());
	        usuariodb.setContraseña(usuario.getContraseña());
	        
	        // Guarda el usuario actualizado
	        usuarioService.save(usuariodb);
	        
	        // Redirige a la lista de usuarios
	        return "redirect:/usuario2";
	    } else {
	        // Agrega un mensaje de error al modelo y redirige a una página de error
	        model.addAttribute("error", "Usuario no encontrado");
	        return "error"; // Asegúrate de que esta vista existe
	    }
		
	}
	
	
	
	@GetMapping("/delete/{idUsuario}")
    public String delete(@PathVariable("idUsuario") Integer idUsuario) {
        Optional<Usuario> optionalUsuario = usuarioService.get(idUsuario);
        if (optionalUsuario.isPresent()) {
            usuarioService.delete(idUsuario);
        }
        return "redirect:/usuario2";
    }
	

}
