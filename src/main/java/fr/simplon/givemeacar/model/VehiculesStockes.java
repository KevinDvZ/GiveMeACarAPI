package fr.simplon.givemeacar.model;

import javax.persistence.*;

// annoter dans le but d'indiquer à hibernate de générer les tables
@Entity
public class VehiculesStockes {

    // toujours écrire cet ensemble de code pour générer l'id automatiquement dans la BDD
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idVehiculeStockes;

    @OneToOne
    private Vehicule vehicule;
}
