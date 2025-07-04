package com.example.ChallengeForumHub.controller.ControllerUsuario;

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

import com.example.ChallengeForumHub.Repository.RepositoryUsuario;
import com.example.ChallengeForumHub.principalTabelas.PrincipalUsuario;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private RepositoryUsuario repository;

    @GetMapping
    public ResponseEntity<?> listarUsuarios() {
        var usuarios = repository.findAll().stream().map(ListagemUsuario::new).toList();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTopicoPorId(@PathVariable Long id) {
        Optional<PrincipalUsuario> optionalUsuario = repository.findById(id);

        if (optionalUsuario.isPresent()) {
            var usuario= optionalUsuario.get();
            var dados = new ListagemUsuario(usuario); // você pode adaptar esse DTO
            return ResponseEntity.ok(dados);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PrincipalUsuario usuario) {
        repository.save(usuario);
        return ResponseEntity.status(201).body(usuario);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody PrincipalUsuario dados) {
        Optional<PrincipalUsuario> optional = repository.findById(id);

        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        PrincipalUsuario usuario = optional.get();

        usuario.setNome(dados.getNome());
        usuario.setEmail(dados.getEmail());
        usuario.setSenha(dados.getSenha());
        usuario.setPerfis(dados.getPerfis());

        return ResponseEntity.ok(usuario); // retorna o usuário atualizado
    }

    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluirTopico(@PathVariable Long id) {
        Optional<PrincipalUsuario> optionalUsuario = repository.findById(id);

        if (optionalUsuario.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
