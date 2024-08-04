package com.tiendavinos.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.tiendavinos.model.Pedido;
import com.tiendavinos.repository.IPedidoRepository;

public class PedidoServiceImpl implements IPedidoService {
	
	@Autowired
	private IPedidoRepository pedidoRepository;

	@Override
	public Pedido save(Pedido pedido) {
		
		return pedidoRepository.save(pedido);
	}

}
