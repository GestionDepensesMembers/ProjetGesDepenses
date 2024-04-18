package com.gestiondepenses.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "depense")
public class depenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddep;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "montant")
    private float montant;

    @Column(name = "datedepaiement")
    private String datedepaiement;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateurs utilisateur;

    
    public depenses() {
    }

    public depenses(String type, String description, float montant, String datedepaiement) {
        this.type = type;
        this.description = description;
        this.montant = montant;
        this.datedepaiement = datedepaiement;
    }

    

    public int getIddep() {
        return iddep;
    }

    public void setIddep(int iddep) {
        this.iddep = iddep;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getDatedepaiement() {
        return datedepaiement;
    }

    public void setDatedepaiement(String datedepaiement) {
        this.datedepaiement = datedepaiement;
    }

    public Utilisateurs getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateurs utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return "depenses [iddep=" + iddep + ", type=" + type + ", description=" + description + ", montant=" + montant
                + ", datedepaiement=" + datedepaiement + ", utilisateur=" + utilisateur + "]";
    }
}
