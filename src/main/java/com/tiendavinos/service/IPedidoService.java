package com.tiendavinos.service;

import java.util.List;

import com.tiendavinos.model.Pedido;

public interface IPedidoService {
	List<Pedido> findAll();
	Pedido save (Pedido pedido);
	String generarNumeroPedido();

}
