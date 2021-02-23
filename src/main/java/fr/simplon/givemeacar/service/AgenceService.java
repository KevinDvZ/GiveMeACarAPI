package fr.simplon.givemeacar.service;


import fr.simplon.givemeacar.model.Agence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgenceService {

    List<Agence> listAllAgence();
    Agence ajouterAgence(Agence agence);
}
