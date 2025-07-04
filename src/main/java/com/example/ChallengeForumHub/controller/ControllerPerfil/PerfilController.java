package com.example.ChallengeForumHub.controller.ControllerPerfil;

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

import com.example.ChallengeForumHub.Dto.perfil.DadosPerfil;
import com.example.ChallengeForumHub.Repository.RepositoryPerfil;
import com.example.ChallengeForumHub.principalTabelas.PrincipalPerfil;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("perfil")
public class PerfilController {

    @Autowired
    private RepositoryPerfil repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody DadosPerfil dados) {
        var perfil = new PrincipalPerfil(
            null,
            dados.nome()
        );

        repository.save(perfil);
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public List<PrincipalPerfil> listarperfils() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<PrincipalPerfil> perfil = repository.findById(id);
        return perfil.isPresent() ? ResponseEntity.ok(perfil.get()) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid DadosPerfil dados) {
        Optional<PrincipalPerfil> optional = repository.findById(id);

        if (optional.isPresent()) {
            PrincipalPerfil perfil = optional.get();
            perfil.setNome(dados.nome());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        Optional<PrincipalPerfil> perfil = repository.findById(id);

        if (perfil.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
