package com.example.teste.models;

import com.example.teste.dtos.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Integer id;

    @NotBlank
    @NotNull
    @NotEmpty(message = "Campo NOME não pode ser vazio")
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NotBlank
    @NotNull
    @NotEmpty(message = "Campo E-MAIL não pode ser vazio")
    @Column(name = "email", length = 100, nullable = false, unique = true)
    @Email(message = "Informe um E-MAIL válido")
    private String email;

    @NotBlank
    @NotNull
    @Size(min = 6, max = 50)
    @NotEmpty(message = "Campo SENHA não pode ser vazio")
    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @NotBlank
    @NotNull
    @Size(min = 6, max = 50)
    @NotEmpty(message = "Campo CONFIRMAÇÃO DE SENHA não pode ser vazio")
    @Column(name = "passwordConfirm", length = 20, nullable = false)
    private String passwordConfirm;

    public Usuario(UsuarioDTO usuarioDTO){
        this.id = usuarioDTO.getId();
        this.name = usuarioDTO.getName();
        this.email = usuarioDTO.getEmail();
        this.password = usuarioDTO.getPassword();
        this.passwordConfirm = usuarioDTO.getPasswordConfirm();
    }
}
