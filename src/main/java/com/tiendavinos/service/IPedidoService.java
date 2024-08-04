package com.tiendavinos.service;

import java.util.List;

import com.tiendavinos.model.Pedido;
import com.tiendavinos.model.Usuario;

public interface IPedidoService {
	List<Pedido> findAll();
	Pedido save (Pedido pedido);
	String generarNumeroPedido();
	List<Pedido> findByUsuario (Usuario usuario);

}
