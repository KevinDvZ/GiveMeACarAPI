package fr.simplon.givemeacar.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @OneToOne
    private Adresse adresse;

    @OneToMany(cascade = CascadeType.ALL)
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
