package com.example.teste.services;


import com.example.teste.dtos.UsuarioDTO;
import com.example.teste.models.Usuario;
import com.example.teste.repositories.UsuarioRepository;
import com.example.teste.services.exceptions.DataIntegrityViolationException;
import com.example.teste.services.exceptions.MethodArgumentNotValidException;
import com.example.teste.services.exceptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findById(Integer id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        return usuario.orElseThrow(() -> new ObjectnotFoundException("Usuario não encontrado! ID: " + id));
    }

    public Usuario create(UsuarioDTO usuarioDTO) {
        usuarioDTO.setId(null);
        validaPorNomeEEmail(usuarioDTO);
        Usuario novoUsuario = new Usuario(usuarioDTO);
        return usuarioRepository.save(novoUsuario);
    }

    private void validaPorNomeEEmail(UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioDTO.getEmail());
        if (usuario.isPresent() && usuario.get().getEmail() == usuario.get().getEmail()){
            throw new DataIntegrityViolationException("E-MAIL já cadastrado no sistema!");
        }
        usuario = usuarioRepository.findByName(usuarioDTO.getName());
        if (usuario.isPresent() && usuario.get().getName().length() < 3) {
            throw new MethodArgumentNotValidException("NOME precisa ter no minimo 3 caracteres!");
        } else if (usuario.isPresent() && usuario.get().getName().length() >= 3 && usuario.get().getName().length() >= 50) {
            throw new MethodArgumentNotValidException("NOME precisa ter no máximo 50 caracteres!");
        }

    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }



}
