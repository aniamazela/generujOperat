package pl.generujoperat.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="Company")
@Entity
public class Company {
    @Id @GeneratedValue
 private Long id;
 private String name;
 private String city;
 private String street;
 private String houseNumber;
 private String zipCode;  
}
