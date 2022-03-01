package com.repositories;

import com.entities.Dog;
import com.entities.Filiere_Langue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Filiere_LangueRepository extends JpaRepository<Filiere_Langue, Long> {
}
