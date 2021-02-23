package fr.simplon.givemeacar.controller;


import fr.simplon.givemeacar.model.Vehicule;
import fr.simplon.givemeacar.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
public class VehiculeController {

    @Autowired
    VehiculeService vehiculeService;

    @GetMapping("/vehicules")
    List<Vehicule> listAllVehicules(){
        return vehiculeService.listAllVehicules();
    }



}
