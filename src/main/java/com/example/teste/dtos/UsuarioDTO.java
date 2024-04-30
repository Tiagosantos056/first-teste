package com.example.teste.dtos;

import com.example.teste.models.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Integer id;

    @NotBlank
    @NotNull
    @Size(min = 3, max = 50)
    @NotEmpty(message = "Campo NOME não pode ser vazio")
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NotBlank
    @NotNull
    @NotEmpty(message = "Campo E-MAIL não pode ser vazio")
    @Column(name = "email", length = 100, nullable = false, unique = true)
    @Email
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

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.name = usuario.getName();
        this.email = usuario.getEmail();
        this.password = usuario.getPassword();
        this.passwordConfirm = usuario.getPasswordConfirm();
    }
}
