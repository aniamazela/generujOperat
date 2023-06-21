package pl.generujoperat.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.generujoperat.model.Property;

public interface IdentifierRepository extends JpaRepository<Property, Long>{

    Optional<Property> findByTeryt(String Teryt);
}
