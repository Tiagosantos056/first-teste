package com.example.teste.controller;

import com.example.teste.dtos.UsuarioDTO;
import com.example.teste.models.Usuario;
import com.example.teste.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id){
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(new UsuarioDTO(usuario));
    }


    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        List<Usuario> list = usuarioService.findAll();
        List<UsuarioDTO> listDTO = list.stream().map(usuario -> new UsuarioDTO(usuario)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario novo = usuarioService.create(usuarioDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(novo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
