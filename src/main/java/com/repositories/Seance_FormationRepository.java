package com.repositories;

import com.entities.Dog;
import com.entities.Seance_Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Seance_FormationRepository extends JpaRepository<Seance_Formation, Long> {
}
