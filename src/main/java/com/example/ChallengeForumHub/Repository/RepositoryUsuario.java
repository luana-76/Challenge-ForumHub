package com.example.ChallengeForumHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.ChallengeForumHub.principalTabelas.PrincipalUsuario;

public interface RepositoryUsuario extends JpaRepository<PrincipalUsuario, Long>{

    UserDetails findByEmail(String email);

}
