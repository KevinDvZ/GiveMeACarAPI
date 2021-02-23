package fr.simplon.givemeacar.controller;

import fr.simplon.givemeacar.model.Agence;
import fr.simplon.givemeacar.service.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// permet d'autoriser toutes les requetes et d'éviter les erreurs dans Postman
@CrossOrigin("*")

//très important, sinon rien ne se passe
@RestController
public class AgenceController {

    // injection du service avec autowired sur une instance du service /!\ on injecte pas l'implémentation, mais l'interface
    @Autowired
    AgenceService agenceService;

    // permet de lister la totalité des agences, renvoyée en Json
    @GetMapping("/agences")
    public List<Agence> getAllAgences() {
        return agenceService.listAllAgence();
    }

    //permet d'ajouter une agence
    @PostMapping("/agences/ajouter")
    @ResponseBody // récupération du body dy json
    public String ajouterAgence(@RequestBody Agence agence){
        agenceService.ajouterAgence(agence);
        final String s = "agence bien enregistré";
        return s;
    }



}
