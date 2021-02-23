package fr.simplon.givemeacar.controller;

import fr.simplon.givemeacar.model.Adresse;
import fr.simplon.givemeacar.model.Agence;
import fr.simplon.givemeacar.service.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// permet d'autoriser toutes les requetes
@CrossOrigin("*")

//annotation très importante, sinon rien ne se passe
@RestController
// !

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
    @ResponseBody // récupération du body du json
    public String ajouterAgence(@RequestBody Agence agence){
        agenceService.ajouterAgence(agence);
        final String s = "Agence bien enregistrée";
        return s;
    }

    //permet de modifier l'agences visées par l'id
    @PutMapping("/agences/{id}")
    @ResponseBody
    public Agence modifierAgence(@PathVariable(value="id") long id,@RequestBody Agence agence){
        return agenceService.updateAgence(id, agence);
    }

    @DeleteMapping("/agences/{id}")
    public Agence deleteAgences(@PathVariable(value="id") long id){
        return agenceService.deleteAgence(id);
    }


}
