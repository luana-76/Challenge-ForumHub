package com.example.ChallengeForumHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ChallengeForumHub.principalTabelas.PrincipalTopico;

public interface RepositoryTopico extends JpaRepository<PrincipalTopico, Long>{

}
