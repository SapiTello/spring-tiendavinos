package com.tiendavinos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiendavinos.model.Usuario;

@Repository
public interface IUsuarioRepository2 extends JpaRepository<Usuario, Integer>{

}
