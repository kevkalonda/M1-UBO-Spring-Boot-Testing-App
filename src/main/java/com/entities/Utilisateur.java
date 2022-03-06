package com.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * On va representé dans la base de donée une table par entité
 * Les attributs hérités seront réprésenés dans chaque table
 * La notion d'heritage ne sera pas représenté dans la base de donnée rélationnelle
 */

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="user")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String login;
    private String motDePasse;
    private String nomUsuel;
    private String prenom;
    private String mail;
}
