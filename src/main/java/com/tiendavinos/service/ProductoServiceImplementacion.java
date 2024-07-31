package com.tiendavinos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendavinos.model.Producto;
import com.tiendavinos.repository.ProductoRepository;

@Service
public class ProductoServiceImplementacion implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return productoRepository.save(producto);
	}

	@Override
	public Optional<Producto> get(Integer idProducto) {
		// TODO Auto-generated method stub
		return productoRepository.findById(idProducto);
	}

	@Override
	public void update(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	public void delete(Integer idProducto) {
		productoRepository.deleteById(idProducto);
		
	}

	@Override
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

}
