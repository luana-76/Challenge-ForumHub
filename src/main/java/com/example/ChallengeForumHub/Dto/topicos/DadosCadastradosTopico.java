package com.example.ChallengeForumHub.Dto.topicos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastradosTopico(

    @NotBlank
    String nome,

    @NotBlank
    String mensagem,

    @NotBlank
    String dataCriacao,

    @NotBlank
    String estadoTopico,

    @NotBlank
    String autor,

    @NotBlank @Valid
    String curso) {

}
