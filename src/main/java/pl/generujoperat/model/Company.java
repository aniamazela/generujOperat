package pl.generujoperat.model;



import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.AccessLevel;

@Data
@Table(name="Companies")
@Entity
@AllArgsConstructor
// @RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class Company {
    @Id @GeneratedValue
 private Long id;
 private String name;
 private String city;
 private String street;
 private String houseNumber;
 private String zipCode;  
 @OneToMany(mappedBy="company")
 private Set <GeodeticWork> geoWorks;
}
