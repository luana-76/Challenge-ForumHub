package com.example.ChallengeForumHub.controller.ControllerCurso;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ChallengeForumHub.Dto.curso.DadosCurso;
import com.example.ChallengeForumHub.Repository.RepositoryCurso;
import com.example.ChallengeForumHub.principalTabelas.PrincipalCurso;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("curso")
public class CursoController {

    @Autowired
    private RepositoryCurso repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody DadosCurso dados) {
        var curso = new PrincipalCurso(
            null,
            dados.nome(),
            dados.categoria()
        );

        repository.save(curso);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<PrincipalCurso> listarCursos() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<PrincipalCurso> curso = repository.findById(id);
        return curso.isPresent() ? ResponseEntity.ok(curso.get()) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid DadosCurso dados) {
        Optional<PrincipalCurso> optional = repository.findById(id);

        if (optional.isPresent()) {
            PrincipalCurso curso = optional.get();
            curso.setNome(dados.nome());
            curso.setCategoria(dados.categoria());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        Optional<PrincipalCurso> curso = repository.findById(id);

        if (curso.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
