package com.example.ChallengeForumHub.Dto.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosCurso(

    @NotBlank
    String nome,

    @NotBlank
    String categoria) {

}
