package com.gestiondepenses.entity;

import  jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
@Entity
@Table(name = "utilisateurs")
public class Utilisateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iduser;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "soldeac")
    private float soldeac;

    @Column(name = "dtn")
    private String dtn;

    @Column(name = "motDepasse")
    private String motDepasse;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<depenses> depensesList;

    
    public Utilisateurs() {
    }

    public Utilisateurs(String nom, String prenom, String email, float soldeac, String dtn, String motDepasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.soldeac = soldeac;
        this.dtn = dtn;
        this.motDepasse = motDepasse;
    }

   

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getSoldeac() {
        return soldeac;
    }

    public void setSoldeac(float soldeac) {
        this.soldeac = soldeac;
    }

    public String getDtn() {
        return dtn;
    }

    public void setDtn(String dtn) {
        this.dtn = dtn;
    }

    public String getMotDepasse() {
        return motDepasse;
    }

    public void setMotDepasse(String motDepasse) {
        this.motDepasse = motDepasse;
    }

    public List<depenses> getDepensesList() {
        return depensesList;
    }

    public void setDepensesList(List<depenses> depensesList) {
        this.depensesList = depensesList;
    }

    @Override
    public String toString() {
        return "Utilisateurs [iduser=" + iduser + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
                + ", soldeac=" + soldeac + ", dtn=" + dtn + ", motDepasse=" + motDepasse + ", depensesList=" + depensesList + "]";
    }
}
