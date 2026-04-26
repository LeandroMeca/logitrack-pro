package com.logitrack.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.logitrack.api.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
