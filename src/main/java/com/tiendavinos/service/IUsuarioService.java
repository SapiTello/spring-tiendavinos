package com.tiendavinos.service;

import java.util.List;
import java.util.Optional;

import com.tiendavinos.model.Usuario;

public interface IUsuarioService {
	List<Usuario> findAllList();
	Optional<Usuario> findById(Integer idUsuario);
	Usuario save(Usuario usuario);
	Optional<Usuario> findByEmail(String email);
	

}
