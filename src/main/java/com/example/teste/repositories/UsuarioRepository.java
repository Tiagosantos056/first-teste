package com.example.teste.repositories;

import com.example.teste.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

   Optional<Usuario> findByEmail(String email);
   Optional<Usuario> findByName(String name);

}
