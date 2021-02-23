package fr.simplon.givemeacar.service;

import fr.simplon.givemeacar.model.Agence;
import fr.simplon.givemeacar.repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// très important de mettre une annotation Service ici aussi; comme pour l'interface
@Service
public class AgenceServiceImpl implements AgenceService{

    // le repository permet de communiquer avec la bdd, il est indispensable de le générer, en utilisant l'autowired pour l'actulaisation
    @Autowired
    private AgenceRepository agenceRepository;

    @Override
    public List<Agence> listAllAgence() {
        return agenceRepository.findAll();
    }

    @Override
    public Optional<Agence> getAgence(Long id) {
        return agenceRepository.findById(id);
    }

    // la méthode n'accepte que le json de type agence. Il fautdra etre en vigilant en front d'envoyer des objets correspondant au modele agence

    @Override
    public Agence ajouterAgence(Agence agence) {
        Agence agenceAajouter = agenceRepository.save(agence);
        // il faut retourner un type agence
        return agenceAajouter;
    }

    @Override
    public Agence updateAgence(long id, Agence agence) {
        Optional<Agence> optionalAgence = this.getAgence(id);
        if(optionalAgence.isPresent()){
            return agenceRepository.save(agence);
        }
    return null;
    }


}
