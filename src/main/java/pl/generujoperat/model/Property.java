package pl.generujoperat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="Properties")
@Entity
public class Property {
    @Id @GeneratedValue
    private Long id;
    private String teryt; 
    private String voivodship;
    private String county; 
    private String gmina;
    private String guarter;
}
