package com.logitrack.api.repository;

import com.logitrack.api.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Aqui o Spring Data JPA faz a "magia":
    // Já temos save(), findAll(), findById() e delete() prontos.
}