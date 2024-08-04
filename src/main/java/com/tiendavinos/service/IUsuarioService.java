package com.tiendavinos.service;

import java.util.Optional;

import com.tiendavinos.model.Usuario;

public interface IUsuarioService {
	Optional<Usuario> findById(Integer idUsuario);
	Usuario save(Usuario usuario);
	Optional<Usuario> findByEmail(String email);
	

}
