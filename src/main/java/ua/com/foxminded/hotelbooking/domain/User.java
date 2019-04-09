package ua.com.foxminded.hotelbooking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 20)
    @NotNull(message = "required")
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;

    @Size(min = 1, max = 20)
    @NotNull(message = "required")
    @Column(name = "LASTNAME", nullable = false)
    private String lastName;
}
