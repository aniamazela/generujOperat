package pl.generujoperat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.generujoperat.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{
    
}
