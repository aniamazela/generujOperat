package pl.generujoperat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.generujoperat.model.GeodeticWork;

public interface GeodeticWorkRepository extends JpaRepository<GeodeticWork, Long>{
    
}
