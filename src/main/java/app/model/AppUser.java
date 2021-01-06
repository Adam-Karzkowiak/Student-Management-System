package app.model;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@ToString
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Providing username is obligatory")
    private String username;

    private String password;
    private String name;
    private String surname;

    @PESEL(message = "Invalid PESEL")
    private String pesel;
    private boolean isProfessor;
}
