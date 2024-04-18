package com.gestiondepenses.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestiondepenses.entity.Utilisateurs;
import com.gestiondepenses.repository.UtilisateursRepository;

@RestController
@CrossOrigin
public class UtilisateursControler {

    @Autowired
    private UtilisateursRepository repo;

    @GetMapping("/utilisateurs")
    public List<Utilisateurs> getAllUtilisateurs() {
        return repo.findAll();
    }

    @GetMapping("/utilisateurs/{iduser}")
    public Utilisateurs getUtilisateurs(@PathVariable int iduser) {
        return repo.findById(iduser).orElse(null);
    }

    @PostMapping("/utilisateurs/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUtilisateur(@RequestBody Utilisateurs utilisateurs) {
        repo.save(utilisateurs);
    }

    @PutMapping("/utilisateurs/update/{iduser}")
    public Utilisateurs updateUtilisateur(@PathVariable int iduser, @RequestBody Utilisateurs newUtilisateurs) {
        Utilisateurs utilisateurs = repo.findById(iduser).orElse(null);
        if (utilisateurs != null) {
            utilisateurs.setNom(newUtilisateurs.getNom());
            utilisateurs.setPrenom(newUtilisateurs.getPrenom());
            utilisateurs.setEmail(newUtilisateurs.getEmail());
            utilisateurs.setDtn(newUtilisateurs.getDtn());
            utilisateurs.setSoldeac(newUtilisateurs.getSoldeac());
            utilisateurs.setMotDepasse(newUtilisateurs.getMotDepasse());
            return repo.save(utilisateurs);
        } else {
            return null;
        }
    }

    @DeleteMapping("/utilisateurs/delete/{iduser}")
    public void removeStudent(@PathVariable int iduser) {
        Utilisateurs utilisateurs = repo.findById(iduser).orElse(null);
        if (utilisateurs != null) {
            repo.delete(utilisateurs);
        }
    }

    
    @PostMapping("/utilisateurs/login")
    public ResponseEntity<?> login(@RequestBody Utilisateurs utilisateurs) {
        Optional<Utilisateurs> userOpt = repo.findByEmailAndMotDepasse(utilisateurs.getEmail(), utilisateurs.getMotDepasse());
        if (userOpt.isPresent()) {
            return ResponseEntity.ok(userOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
