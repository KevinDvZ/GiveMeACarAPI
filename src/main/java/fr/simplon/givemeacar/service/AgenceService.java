package fr.simplon.givemeacar.service;


import fr.simplon.givemeacar.model.Agence;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AgenceService {

    // Requetes GET
    List<Agence> listAllAgence();

    // Methode intermédiaires
    Optional<Agence> getAgence(Long id);


    // Requetes POST ou PUT
    Agence ajouterAgence(Agence agence);

    Agence updateAgence(long id, Agence agence);
}
