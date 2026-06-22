package br.com.galleriabank.desafio.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "login")
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String login;
    private String password;
    private Boolean active = true;
}
