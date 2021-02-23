package fr.simplon.givemeacar.controller;

import fr.simplon.givemeacar.model.Adresse;
import fr.simplon.givemeacar.repository.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController

public class AdresseController {

    @Autowired
    AdresseRepository adresseRepository;

    @GetMapping("/adresses")
    List<Adresse> listAllAdresses(){
        return adresseRepository.findAll();
    }

    // ajout une adresse à la fois
    @PostMapping("/adresses/ajouter")
    @ResponseBody
    public Adresse ajouterAdresse(@RequestBody Adresse adresse){

        return adresseRepository.save(adresse);
    }

    // ajouter plusieurs adresses à la fois
    @PostMapping("/adresses/ajouter/list")
    @ResponseBody
    public List<Adresse> ajouterAdresses(@RequestBody List<Adresse> adresses){
        return adresseRepository.saveAll(adresses);
    }


}
