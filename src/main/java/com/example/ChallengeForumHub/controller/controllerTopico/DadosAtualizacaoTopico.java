package com.example.ChallengeForumHub.controller.controllerTopico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
    
    @NotNull
    Long id, 
    String nome, 
    String mensagem, 
    String dataCriacao) {

}
