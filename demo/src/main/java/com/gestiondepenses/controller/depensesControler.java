package com.gestiondepenses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.gestiondepenses.entity.Utilisateurs;
import com.gestiondepenses.entity.depenses;
import com.gestiondepenses.repository.depensesRepository;
import com.gestiondepenses.repository.UtilisateursRepository;

@RestController
@RequestMapping("/depense")
public class depensesControler {

    @Autowired
    private depensesRepository repoo;

    @Autowired
    private UtilisateursRepository utilisateurRepository;

    @GetMapping
    public List<depenses> getAllDepenses() {
        return repoo.findAll();
    }

    @GetMapping("/{iddep}")
    public depenses getDepense(@PathVariable int iddep) {
        return repoo.findById(iddep).orElse(null);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public depenses createDepense(@RequestBody depenses depense) {
        return repoo.save(depense);
    }

    @PutMapping("/update/{iddep}")
    public depenses updateDepense(@PathVariable int iddep, @RequestBody depenses updatedDepense) {
        depenses existingDepense = repoo.findById(iddep).orElse(null);
        if (existingDepense != null) {
            existingDepense.setType(updatedDepense.getType());
            existingDepense.setDescription(updatedDepense.getDescription());
            existingDepense.setMontant(updatedDepense.getMontant());
            existingDepense.setDatedepaiement(updatedDepense.getDatedepaiement());
            existingDepense.setUtilisateur(updatedDepense.getUtilisateur());
            return repoo.save(existingDepense);
        }
        return null;
    }

    @DeleteMapping("/delete/{iddep}")
    public void removeDepense(@PathVariable int iddep) {
        depenses depense = repoo.findById(iddep).orElse(null);
        if (depense != null) {
            repoo.delete(depense);
        }
    }

    @GetMapping("/utilisateurs/{iduser}")
    public List<depenses> getDepensesByUtilisateur(@PathVariable int iduser) {
        return repoo.findByUtilisateurIduser(iduser);
    }

    @PostMapping("/utilisateurs/add")
    @ResponseStatus(HttpStatus.CREATED)
    public depenses addDepenseToUser(@RequestParam int iduser, @RequestBody depenses depense) {
        // Trouver l'utilisateur par son ID
        Utilisateurs utilisateur = utilisateurRepository.findById(iduser).orElse(null);
        if (utilisateur != null) {
            // Associer l'utilisateur à la dépense
            depense.setUtilisateur(utilisateur);
            // Enregistrer la dépense
            return repoo.save(depense);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé");
        }
    }
}
