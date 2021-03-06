package fr.simplon.givemeacar.repository;

import fr.simplon.givemeacar.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresseRepository extends JpaRepository <Adresse, Long> {

    List<Adresse> findAll();
}
