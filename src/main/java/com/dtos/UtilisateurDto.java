package com.dtos;

import lombok.Data;

@Data
public class UtilisateurDto {

    private Long Id;
    private String login;
    private String motDePasse;
    private String nomUsuel;
    private String prenom;
    private String mail;
}
