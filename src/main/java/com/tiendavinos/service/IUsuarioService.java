package com.tiendavinos.service;

import java.util.Optional;

import com.tiendavinos.model.Usuario;

public interface IUsuarioService {
	Optional<Usuario> findById(Integer idUsuario);
	

}
