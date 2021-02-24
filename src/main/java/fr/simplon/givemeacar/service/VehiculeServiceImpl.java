package fr.simplon.givemeacar.service;

import fr.simplon.givemeacar.model.Vehicule;
import fr.simplon.givemeacar.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculeServiceImpl implements VehiculeService{

    @Autowired
    VehiculeRepository vehiculeRepository;

    @Override
    public List<Vehicule> listAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule getVehiculeById(Long id) {
       return vehiculeRepository.findByIdVehicule();
    }
}
