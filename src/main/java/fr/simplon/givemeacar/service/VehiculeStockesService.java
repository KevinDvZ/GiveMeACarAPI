package fr.simplon.givemeacar.service;

import fr.simplon.givemeacar.model.Vehicule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehiculeStockesService {

    List<Vehicule> listVehiculeDansAgence();
}
