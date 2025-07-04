package com.example.ChallengeForumHub.principalTabelas;

import com.example.ChallengeForumHub.controller.controllerTopico.DadosAtualizacaoTopico;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "topicos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PrincipalTopico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String mensagem;
    private String dataCriacao;
    private String estadoTopico;
    private String autor;
    private String curso;

    public PrincipalTopico toEntity() {
        return new PrincipalTopico(
            null,
            nome,
            mensagem,
            dataCriacao,
            estadoTopico,
            autor,
            curso
        );
    }

    public void atualizarTopicos(DadosAtualizacaoTopico dados) {
        
        /* Verifica se a entrada não é nulo */
        if(dados.nome() != null){

            this.nome = dados.nome();

        }
        if(dados.mensagem() != null){

            this.mensagem = dados.mensagem();
            
        }
        if(dados.dataCriacao() != null){

            this.dataCriacao = dados.dataCriacao();
            
        }
    }

}
