package com.example.ChallengeForumHub.Dto.perfil;

import jakarta.validation.constraints.NotBlank;

public record DadosPerfil(

    @NotBlank
    String nome
    
    ) {

}
