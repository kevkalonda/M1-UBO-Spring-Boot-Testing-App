package com.repositories;

import com.entities.Vacataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacataireRepository extends JpaRepository<Vacataire, Long> {
}
