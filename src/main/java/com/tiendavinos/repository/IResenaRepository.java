package com.tiendavinos.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.tiendavinos.model.Resena;

public interface IResenaRepository extends JpaRepository<Resena, Integer> {
    
}
