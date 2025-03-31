package main.java.fr.starfleet.modele.personne;



/**
 * La classe Officier hérite de la classe Personne et représente un officier dans le système.
 * Elle ajoute des attributs spécifiques à l'officier tels que le rang et la spécialité.
 */
public class Officier extends Personne  {
    private String rang ;
    private String spécialité ;


    /**
     * Constructeur pour créer un officier avec un rang, une spécialité, et les informations de la personne.
     *
     * @param rang Le rang de l'officier.
     * @param spécialité La spécialité de l'officier.
     * @param nom Le nom de l'officier.
     * @param prenom Le prénom de l'officier.
     * @param identifiant L'identifiant de l'officier.
     */
    public Officier(String rang , String spécialité , String nom , String prenom , String identifiant){
        super(nom , prenom , identifiant);
        this.rang = rang ;
        this.spécialité = spécialité ;
    }


    /**
     * Récupère le rang de l'officier.
     *
     * @return Le rang de l'officier.
     */
    public String getRang() {
        return rang;
    }


    /**
     * Récupère la spécialité de l'officier.
     *
     * @return La spécialité de l'officier.
     */
    public String getSpécialité() {
        return spécialité;
    }

    /**
     * Définit le rang de l'officier.
     *
     * @param rang Le rang à définir.
     */
    public void setRang(String rang) {
        this.rang = rang;
    }

    /**
     * Définit la spécialité de l'officier.
     *
     * @param spécialité La spécialité à définir.
     */
    public void setSpécialité(String spécialité) {
        this.spécialité = spécialité;
    }

    /**
     * Méthode pour obtenir une description complète de l'officier.
     *
     * @return Une chaîne de caractères représentant l'officier avec toutes ses informations.
     */
    @Override
    public String getDescription(){
        return "Officier : " + getNom() + " " + getPrenom() + " " + getIdentifiant() + " " + getRang() + " " + getSpécialité() ;
    }
    @Override
    public String toString() {
        return super.toString() + ", Rang: " + rang + ", Spécialité: " + spécialité;
    }






}
