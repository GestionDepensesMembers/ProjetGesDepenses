package com.gestiondepenses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestiondepenses.entity.depenses;

public interface depensesRepository extends JpaRepository<depenses , Integer>{

	List<depenses> findByUtilisateurIduser(int iduser);

}
