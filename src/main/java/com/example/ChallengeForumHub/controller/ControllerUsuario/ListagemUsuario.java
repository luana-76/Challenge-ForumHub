package com.example.ChallengeForumHub.controller.ControllerUsuario;

import com.example.ChallengeForumHub.principalTabelas.PrincipalUsuario;

public record ListagemUsuario(
    Long id,
    String nome,
    String email,
    String perfis
) {
    public ListagemUsuario(PrincipalUsuario usuario) {
        this(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getPerfis()
        );
    }
}
