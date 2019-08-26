/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Faty
 */
public class Auteur {
    private Integer id;

	private String  nom;
	private String prenom;
	private Integer degre_redaction;
        private Integer id_universite;
        private Integer id_utilisateur ;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDegre_redaction(Integer degre_redaction) {
        this.degre_redaction = degre_redaction;
    }

    public void setId_universite(Integer id_universite) {
        this.id_universite = id_universite;
    }

    public void setId_utilisateur(Integer id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Integer getDegre_redaction() {
        return degre_redaction;
    }

    public Integer getId_universite() {
        return id_universite;
    }

    public Integer getId_utilisateur() {
        return id_utilisateur;
    }

}
