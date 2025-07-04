package com.example.ChallengeForumHub.controller;

import com.example.ChallengeForumHub.principalTabelas.PrincipalTopico;

public record ListagemTopicos(Long id, String nome, String mensagem, String dataCriacao) {

    public ListagemTopicos(PrincipalTopico topicos){

        this(topicos.getId(), topicos.getNome(), topicos.getMensagem(), topicos.getDataCriacao());

    }

}
