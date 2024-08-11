package com.tiendavinos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendavinos.model.Producto;
import com.tiendavinos.model.Proveedor;
import com.tiendavinos.model.Usuario;
import com.tiendavinos.repository.IProductoRepository;
import com.tiendavinos.repository.IProveedorRepository;
import com.tiendavinos.repository.IUsuarioRepository2;

@Service
public class IUsuarioServiceImplementacion implements UsuarioService{
	
	@Autowired
	private IUsuarioRepository2 usuarioRepository2;

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository2.save(usuario);
	}

	@Override
	public Optional<Usuario> get(Integer idUsuario) {
		return usuarioRepository2.findById(idUsuario);
	}

	@Override
	public void update(Usuario usuario) {
		usuarioRepository2.save(usuario);
		
	}

	@Override
	public void delete(Integer idUsuario) {
		usuarioRepository2.deleteById(idUsuario);
		
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository2.findAll();
	}




	

}
