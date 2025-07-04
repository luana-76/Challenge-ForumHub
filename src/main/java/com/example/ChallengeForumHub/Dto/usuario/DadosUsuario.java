package com.example.ChallengeForumHub.Dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosUsuario(

    @NotBlank
    String nome,

    @NotBlank
    String email, 

    @NotBlank
    String senha,

    @NotBlank
    String perfis) {

}
