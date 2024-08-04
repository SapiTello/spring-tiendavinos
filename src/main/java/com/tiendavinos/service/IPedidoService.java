package com.tiendavinos.service;

import java.util.List;
import java.util.Optional;

import com.tiendavinos.model.Pedido;
import com.tiendavinos.model.Usuario;

public interface IPedidoService {
	List<Pedido> findAll();
	Optional<Pedido> findById(Integer idPedido);
	Pedido save (Pedido pedido);
	String generarNumeroPedido();
	List<Pedido> findByUsuario (Usuario usuario);

}
