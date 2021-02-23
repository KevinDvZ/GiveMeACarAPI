package fr.simplon.givemeacar.service;

import fr.simplon.givemeacar.model.Adresse;
import fr.simplon.givemeacar.repository.AdresseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseServiceImpl implements AdresseService{

    AdresseRepository adresseRepository;

    @Override
    public List<Adresse> findAll() {
        return null;
    }

    @Override
    public Adresse ajouterAdresse(Adresse adresse) {
       return  adresseRepository.save(adresse);
    }
}
