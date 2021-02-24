package fr.simplon.givemeacar.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    //permet de référencer l'adresse de l'autre coté
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="adresse")
    private Adresse adresse;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    private List<VehiculesStockes> listVehiculesSotckes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<VehiculesStockes> getListVehiculesSotckes() {
        return listVehiculesSotckes;
    }

    public void setListVehiculesSotckes(List<VehiculesStockes> listVehiculesSotckes) {
        this.listVehiculesSotckes = listVehiculesSotckes;
    }
}
