package pl.generujoperat.model;

import lombok.Data;

import java.time.LocalDate;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import pl.generujoperat.model.Company;
import pl.generujoperat.model.Property;


@Data
@Table(name="geodetic_works")
@Entity
public class GeodeticWork {
    @Id @GeneratedValue
private Long id;
private LocalDate startDate;
private LocalDate finishDate;
@ManyToOne
@JoinColumn(name = "company_id")
private Company company;
}
