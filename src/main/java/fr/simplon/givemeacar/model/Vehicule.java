package fr.simplon.givemeacar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicule {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idVehicule;
    private String marque;
    private String modele;
    private String immatriculation;
    private Long km;
    private String typeEnergie;
    private String geolocalisation;

    public Long getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Long idVehicule) {
        this.idVehicule = idVehicule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Long getKm() {
        return km;
    }

    public void setKm(Long km) {
        this.km = km;
    }

    public String getTypeEnergie() {
        return typeEnergie;
    }

    public void setTypeEnergie(String typeEnergie) {
        this.typeEnergie = typeEnergie;
    }

    public String getGeolocalisation() {
        return geolocalisation;
    }

    public void setGeolocalisation(String geolocalisation) {
        this.geolocalisation = geolocalisation;
    }
}
