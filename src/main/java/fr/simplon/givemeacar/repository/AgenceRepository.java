package fr.simplon.givemeacar.repository;

import fr.simplon.givemeacar.model.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// bien placer en parametre d'entree l'agence et long pour le type de l'id
public interface AgenceRepository extends JpaRepository<Agence, Long> {

   List<Agence> findAll();

}
