package com.example.teste.services;

import com.example.teste.models.Usuario;
import com.example.teste.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Bean
    public void instanciaDB() {

        Usuario usuario1 = new Usuario(null, "Tiago", "tiago@email.com", "123456", "123456");
        Usuario usuario2 = new Usuario(null, "João", "joao@email.com", "123456", "123456");

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);
    }

}
