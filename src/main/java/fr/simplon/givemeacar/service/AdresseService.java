package fr.simplon.givemeacar.service;

import fr.simplon.givemeacar.model.Adresse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdresseService {

    // toutes les requetes GET

    List<Adresse> findAll();


    // toutes les requetes POST
    Adresse ajouterAdresse(Adresse adresse);
    Adresse ajouterAdresses(List<Adresse> adresses);

}
