package com.repositories;

import com.dtos.UtilisateurDto;
import com.entities.Dog;
import com.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByLoginMotDePass(String login, String motDePasse);
}
