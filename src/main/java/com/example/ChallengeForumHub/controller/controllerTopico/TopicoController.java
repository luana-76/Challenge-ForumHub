package com.example.ChallengeForumHub.controller.controllerTopico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ChallengeForumHub.Dto.topicos.DadosCadastradosTopico;
import com.example.ChallengeForumHub.Repository.RepositoryTopico;
import com.example.ChallengeForumHub.controller.ListagemTopicos;
import com.example.ChallengeForumHub.principalTabelas.PrincipalTopico;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    //Importando o repository
    @Autowired
    private RepositoryTopico repository;

    //Caminho do post(Criação de um topico)
    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody DadosCadastradosTopico dados) {
        var topico = new PrincipalTopico(
            null,
            dados.nome(),
            dados.mensagem(),
            dados.dataCriacao(),
            dados.estadoTopico(),
            dados.autor(),
            dados.curso()
        );

        repository.save(topico);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Page<ListagemTopicos> listarTopicos(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao){

        return repository.findAll(paginacao).map(ListagemTopicos::new);
    }

    //Caminho get com id(Volta apenas um topico)
    @GetMapping("/{id}")
    public ResponseEntity<PrincipalTopico> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Caminho put(Edição de topicos)
    @PutMapping
    @Transactional
    public ResponseEntity<?> atualizarTopicos(@RequestBody DadosAtualizacaoTopico dados) {

        var optionalTopico = repository.findById(dados.id());

        if (optionalTopico.isPresent()) {
            var topico = optionalTopico.get();
            topico.atualizarTopicos(dados);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    //Caminho delete(deleta o topico por id)
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> exclusaoTopico(@PathVariable Long id) {

        var optionalTopico = repository.findById(id);

        if (optionalTopico.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content (padrão para delete)
        }

        return ResponseEntity.notFound().build(); // 404 se o id não existir
    }

}
