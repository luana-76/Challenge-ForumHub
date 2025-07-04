package com.example.ChallengeForumHub.principalTabelas;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;

@Table(name = "curso")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PrincipalCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String categoria;

    public PrincipalCurso toEntity() {
        return new PrincipalCurso(
            null,
            nome,
            categoria
        );
    }

    public void setNome(String nome2) {
        this.nome = nome2;
    }

    public void setCategoria(String categoria2) {
        this.categoria = categoria2;
    }

}
