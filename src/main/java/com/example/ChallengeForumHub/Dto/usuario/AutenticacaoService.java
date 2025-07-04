package com.example.ChallengeForumHub.Dto.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ChallengeForumHub.Repository.RepositoryUsuario;

@Service
public class AutenticacaoService implements UserDetailsService{

    @Autowired
    private RepositoryUsuario repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        return repository.findByEmail(email);

    }

}
