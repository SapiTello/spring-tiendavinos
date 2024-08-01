package com.tiendavinos.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.tiendavinos.model.DetallePedido;
import com.tiendavinos.model.Pedido;
import com.tiendavinos.model.Producto;
import com.tiendavinos.service.ProductoService;

@Controller
@RequestMapping("/")
public class HomeController {

	private final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ProductoService productoService;

	// para almacenar los detalles de la orden
	List<DetallePedido> detalles = new ArrayList<DetallePedido>();

	// datos del pedido
	Pedido pedido = new Pedido();

	@GetMapping("")
	public String home(Model model) {

		model.addAttribute("productos", productoService.findAll());

		return "usuario/home";
	}

	@GetMapping("productohome/{idProducto}")
	public String productoHome(@PathVariable Integer idProducto, Model model) {
		log.info("Id producto enviado como parametro {}", idProducto);
		Producto producto = new Producto();
		Optional<Producto> productoOptional = productoService.get(idProducto);
		producto = productoOptional.get();

		model.addAttribute("producto", producto);

		return "usuario/productohome";
	}

	@PostMapping("/cart")
	public String addCart(@RequestParam Integer idProducto, @RequestParam Integer cantidad, Model model) {
		DetallePedido detallePedido = new DetallePedido();
		Producto producto = new Producto();
		double sumaTotal = 0;

		Optional<Producto> optionalProducto = productoService.get(idProducto);
		log.info("Producto añadido: {}", optionalProducto.get());
		log.info("Cantidad: {}", cantidad);
		producto = optionalProducto.get();

		detallePedido.setCantidad(cantidad);
		detallePedido.setPrecio(producto.getPrecio());
		detallePedido.setNombre(producto.getNombre());
		detallePedido.setTotal(producto.getPrecio() * cantidad);
		detallePedido.setProducto(producto);

		detalles.add(detallePedido);

		sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

		pedido.setTotal(sumaTotal);
		model.addAttribute("cart", detalles);
		model.addAttribute("pedido", pedido);

		return "usuario/carrito";
	}

	// quitar un producto del carrito

	@GetMapping("/delete/cart/{idProducto}")
	public String deleteProductoCart(@PathVariable Integer idProducto, Model model) {
		List<DetallePedido> pedidoNuevo = new ArrayList<DetallePedido>();

		for (DetallePedido detallePedido : detalles) {
			if (detallePedido.getProducto().getIdProducto() != idProducto) {
				pedidoNuevo.add(detallePedido);
			}
		}

		// poner la nueva lista con los productos restantes
		detalles = pedidoNuevo;

		double sumaTotal = 0;
		sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

		pedido.setTotal(sumaTotal);
		model.addAttribute("cart", detalles);
		model.addAttribute("pedido", pedido);

		return "usuario/carrito";
	}

}
