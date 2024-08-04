package com.tiendavinos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendavinos.model.DetallePedido;

public interface IDetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {

}
