package fr.simplon.givemeacar.repository;

import fr.simplon.givemeacar.model.VehiculesStockes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiculesStockesRepository extends JpaRepository<VehiculesStockes, Long> {

}
