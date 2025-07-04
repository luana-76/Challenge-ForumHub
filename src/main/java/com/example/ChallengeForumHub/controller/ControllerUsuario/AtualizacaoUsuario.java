package com.example.ChallengeForumHub.controller.ControllerUsuario;

import jakarta.validation.constraints.NotNull;

public record AtualizacaoUsuario(
    @NotNull
    Long id,
    String nome,
    String email,
    String senha,
    String perfis
) {}