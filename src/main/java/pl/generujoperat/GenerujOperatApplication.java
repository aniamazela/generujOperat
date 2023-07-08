package pl.generujoperat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pl.generujoperat.model.Company;
import pl.generujoperat.repositories.CompanyRepository;

@SpringBootApplication
public class GenerujOperatApplication {

	@Autowired
	static
	CompanyRepository companyRepo;

	public static void main(String[] args) {
		SpringApplication.run(GenerujOperatApplication.class, args);
		// Company company1=new Company (0L, "Firma1", "Warszawa", "ul. Syta", "25/63", "02-685");
		// companyRepo.save(company1);
	}

}
