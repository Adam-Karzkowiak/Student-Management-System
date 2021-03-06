package app.model;


import app.validation.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Providing username is obligatory")
    private String username;

    @ValidPassword
    private String password;

    @NotBlank(message = "Providing name is obligatory")
    private String name;

    @NotBlank(message = "Providing surname is obligatory")
    private String surname;

    @PESEL(message = "Invalid PESEL")
    private String pesel;

    @NotNull(message = "User type must be specified")
    private boolean isProfessor;
}
