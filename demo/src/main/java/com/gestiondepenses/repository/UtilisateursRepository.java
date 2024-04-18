package com.gestiondepenses.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestiondepenses.entity.Utilisateurs;

public interface UtilisateursRepository extends JpaRepository<Utilisateurs , Integer>{

	Optional<Utilisateurs> findByEmailAndMotDepasse(String email, String motDepasse);

}

