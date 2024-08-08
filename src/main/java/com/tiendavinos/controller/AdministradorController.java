package com.tiendavinos.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiendavinos.model.Pedido;
import com.tiendavinos.model.Producto;
import com.tiendavinos.model.Usuario;
import com.tiendavinos.service.IPedidoService;
import com.tiendavinos.service.IUsuarioService;
import com.tiendavinos.service.ProductoService;
import com.tiendavinos.service.ProveedorService;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ProveedorService proveedorService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IPedidoService pedidoService;

	
	private Logger logg = LoggerFactory.getLogger(AdministradorController.class);
	
	@GetMapping("")
	public String home(Model model) {
		
		List<Producto> productos = productoService.findAll();
		model.addAttribute("productos",productos);
		
		return "administrador/home";
		
	}
	
	@GetMapping("/usuarios")
	public String usuarios(Model model) {
		model.addAttribute("usuarios", usuarioService.findAllList());
		return "administrador/usuarios";
	}
	
	@GetMapping("/pedidos")
	public String pedidos(Model model) {
		model.addAttribute("pedidos",pedidoService.findAll());
		return "administrador/pedidos";
	}
	
	@GetMapping("/proveedores")
	public String proveedores(Model model) {
		model.addAttribute("proveedores",proveedorService.findAll());
		return "administrador/proveedores";
	}
	
	@GetMapping("/detalle/{idPedido}")
	public String detalle(Model model, @PathVariable Integer idPedido) {
		logg.info("id del pedido {}", idPedido);
		Pedido pedido = pedidoService.findById(idPedido).get();
		
		model.addAttribute("detalles", pedido.getDetallePedido());		
		
		return "administrador/detallepedido";
	}
	
	public String proveedor(Model model) {
		return "";
	}
	
	
}
