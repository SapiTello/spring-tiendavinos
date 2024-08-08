package com.tiendavinos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendavinos.model.Producto;
import com.tiendavinos.model.Proveedor;
import com.tiendavinos.repository.IProductoRepository;
import com.tiendavinos.repository.IProveedorRepository;

@Service
public class ProveedorServiceImplementacion implements ProveedorService{
	
	@Autowired
	private IProveedorRepository proveedorRepository;

	@Override
	public Proveedor save(Proveedor proveedor) {
		return proveedorRepository.save(proveedor);
	}

	@Override
	public Optional<Proveedor> get(Integer idProveedor) {
		return proveedorRepository.findById(idProveedor);
	}

	@Override
	public void update(Proveedor proveedor) {
		proveedorRepository.save(proveedor);
		
	}

	@Override
	public void delete(Integer idProveedor) {
		proveedorRepository.deleteById(idProveedor);
		
	}

	@Override
	public List<Proveedor> findAll() {
		return proveedorRepository.findAll();
	}

	

}
