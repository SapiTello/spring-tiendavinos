package com.tiendavinos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiendavinos.model.Pedido;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {

}
