package com.tiendavinos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendavinos.model.Pedido;
import com.tiendavinos.model.Usuario;
import com.tiendavinos.repository.IPedidoRepository;

@Service
public class PedidoServiceImpl implements IPedidoService {
	
	@Autowired
	private IPedidoRepository pedidoRepository;

	@Override
	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}
	
	//formato del numero 000010
	public String generarNumeroPedido() {
		int numero=0;
		
		String numeroConcatenado=""; 
		
		List<Pedido> pedidos = findAll();
		
		List<Integer> numeros= new ArrayList<Integer>();
		
		pedidos.stream().forEach(o -> numeros.add(Integer.parseInt( o.getNumero() )));
		
		if (pedidos.isEmpty()) {
			numero=1;
		}else {
			numero= numeros.stream().max(Integer::compare).get();
			numero++;
		}
		
		if (numero<10) { //0000000001
			numeroConcatenado="000000000"+String.valueOf(numero);
		}else if(numero<100) {
			numeroConcatenado="00000000"+String.valueOf(numero);
		}else if(numero<1000) {
			numeroConcatenado="0000000"+String.valueOf(numero);
		}else if(numero<10000) {
			numeroConcatenado="000000"+String.valueOf(numero);
		}else if(numero<100000) {
			numeroConcatenado="00000"+String.valueOf(numero);
		}else if(numero<1000000) {
			numeroConcatenado="0000"+String.valueOf(numero);
		}
		
		return numeroConcatenado;
	}

	@Override
	public List<Pedido> findByUsuario(Usuario usuario) {
		return pedidoRepository.findByUsuario(usuario);
	}

}
