package com.tiendavinos.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiendavinos.model.Pedido;
import com.tiendavinos.model.Usuario;
import com.tiendavinos.service.IPedidoService;
import com.tiendavinos.service.IUsuarioService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final Logger logger= LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IPedidoService pedidoService;
	
	
	// /usuario/registro
	@GetMapping("/registro")
	public String create() {
		return "usuario/registro";
	}
	
	@PostMapping("/save")
	public String save(Usuario usuario) {
		logger.info("Usuario registro: {}", usuario);
		usuario.setTipo("USER");
		usuarioService.save(usuario);
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login(){
		return "usuario/login";
	}
	
	@PostMapping("/acceder")
	public String acceder(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, Model model) {
	    logger.info("Intento de acceso con email: {}", email);
	    
	    Optional<Usuario> userOpt = usuarioService.findByEmail(email);
	    
	    if (userOpt.isPresent()) {
	        Usuario user = userOpt.get();
	        // Verifica si la contraseña proporcionada coincide con la almacenada
	        if (user.getContraseña().equals(password)) { // Asumiendo que tienes un método getPassword()
	            session.setAttribute("idUsuario", user.getIdUsuario());
	            if (user.getTipo().equals("ADMIN")) {
	                return "redirect:/administrador";
	            } else {
	                return "redirect:/";
	            }
	        } else {
	            logger.info("Contraseña incorrecta");
	            model.addAttribute("error","Contraseña Incorrecta");
	        }
	    } else {
	        logger.info("Usuario no existe");
	        model.addAttribute("error","usuario no creado");
	    }
	    
	    return "usuario/login"; // Redirige a la página de login con un parámetro de error
	}

	
	@GetMapping("/compras")
	public String obtenerCompras(Model model, HttpSession session) {
		model.addAttribute("sesion", session.getAttribute("idUsuario"));
		Usuario usuario = usuarioService.findById(Integer.parseInt(session.getAttribute("idUsuario").toString())).get();
		List<Pedido> pedidos= pedidoService.findByUsuario(usuario);
		
		model.addAttribute("pedidos", pedidos);
		
		return "usuario/compras";
	}
	
	@GetMapping("/detalle/{idPedido}")
	public String detalleCompra(@PathVariable Integer idPedido, HttpSession session, Model model) {
		logger.info("Id del pedido: {}", idPedido);
		Optional <Pedido> pedido = pedidoService.findById(idPedido);
		
		model.addAttribute("detalles",pedido.get().getDetallePedido());
		
		//session
		model.addAttribute("sesion",session.getAttribute("idUsuario"));
		return "usuario/detallecompra";
		
	}
	
	@GetMapping("/cerrar")
	public String cerrarSesion(HttpSession session) {
		session.removeAttribute("idUsuario");
		return "redirect:/";
	}
	
	
	

}
