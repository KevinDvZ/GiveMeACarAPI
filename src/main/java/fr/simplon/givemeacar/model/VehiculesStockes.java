package fr.simplon.givemeacar.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;


// annoter dans le but d'indiquer à hibernate de générer les tables
@Entity
public class VehiculesStockes {

    // toujours écrire cet ensemble de code pour générer l'id automatiquement dans la BDD
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idVehiculeStockes;


    @OneToOne
    @JoinColumn(name="idVehicule")
    @JsonIdentityInfo(generator=  ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId = true)
    private Vehicule vehicule;

    @OneToOne
    @JoinColumn(name="agence")
    private Agence agence;


    public Long getIdVehiculeStockes() {
        return idVehiculeStockes;
    }

    public void setIdVehiculeStockes(Long idVehiculeStockes) {
        this.idVehiculeStockes = idVehiculeStockes;
    }
}
