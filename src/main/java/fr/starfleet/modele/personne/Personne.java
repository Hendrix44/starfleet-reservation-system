package main.java.fr.starfleet.modele.personne;


/**
 * La classe abstraite Personne représente une personne dans le système, avec des attributs
 * communs à toutes les personnes, tels que le nom, le prénom et l'identifiant.
 * Les classes spécifiques comme Officier ou Civil hériteront de cette classe et ajouteront
 * leurs propres attributs et comportements.
 */
public abstract class Personne {


    private String nom;
    private String prenom;
    private String identifiant;


    /**
     * Constructeur pour créer une personne avec un nom, un prénom et un identifiant.
     *
     * @param nom Le nom de la personne.
     * @param prenom Le prénom de la personne.
     * @param identifiant L'identifiant de la personne.
     */
    public Personne (String nom , String prenom , String identifiant){
        this.nom = nom ;
        this.prenom = prenom ;
        this.identifiant = identifiant ;
    }


    /**
     * Récupère le nom de la personne.
     *
     * @return Le nom de la personne.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Récupère l'identifiant de la personne.
     *
     * @return L'identifiant de la personne.
     */
    public String getIdentifiant() {
        return identifiant;
    }


    /**
     * Récupère le prénom de la personne.
     *
     * @return Le prénom de la personne.
     */
    public String getPrenom() {
        return prenom;
    }


    /**
     * Définit l'identifiant de la personne.
     *
     * @param identifiant L'identifiant à définir.
     */
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }


    /**
     * Définit le nom de la personne.
     *
     * @param nom Le nom à définir.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }


    /**
     * Définit le prénom de la personne.
     *
     * @param prenom Le prénom à définir.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    /**
     * Méthode abstraite permettant de récupérer une description complète de la personne.
     * Cette méthode sera implémentée par les sous-classes pour fournir une description
     * spécifique en fonction du type de personne (ex: Officier, Civil, etc.).
     *
     * @return Une chaîne de caractères représentant la personne.
     */
    public abstract String getDescription();

    /**
     * Méthode toString pour afficher les informations de la personne.
     *
     * @return Une chaîne de caractères contenant le nom, le prénom et l'identifiant de la personne.
     */
    @Override
    public String toString() {
        return "Nom: " + nom + ", Prénom: " + prenom + ", Identifiant: " + identifiant;
    }






}
