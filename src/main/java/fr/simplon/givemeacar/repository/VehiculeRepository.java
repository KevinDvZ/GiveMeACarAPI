package fr.simplon.givemeacar.repository;

import fr.simplon.givemeacar.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    List<Vehicule> findAll();
    Vehicule findByIdVehicule();
}
