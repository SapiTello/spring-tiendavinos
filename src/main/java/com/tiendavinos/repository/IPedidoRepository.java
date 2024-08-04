package com.tiendavinos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiendavinos.model.Pedido;
import com.tiendavinos.model.Usuario;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {
	
	List<Pedido> findByUsuario (Usuario usuario);
}
