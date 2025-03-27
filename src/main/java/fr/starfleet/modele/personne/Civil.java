package main.java.fr.starfleet.modele.personne;

/**
 * Représente un Civil, une sous-classe de Personne
 * Un Civil est caractérisé par sa planète d'origine et le motif de son voyage.
 */

public class Civil extends Personne {
    /**
     * La planète d'origine du civil.
     */
    private String planète_origine ;


    /**
     * Le motif du voyage du civil.
     */
    private String motif_voyage ;



    /**
     * Constructeur pour créer un Civil avec des informations spécifiques à son identité,
     * sa planète d'origine et le motif de son voyage.
     *
     * @param planète_origine La planète d'origine du civil.
     * @param motif_voyage Le motif du voyage du civil.
     * @param nom Le nom du civil.
     * @param prenom Le prénom du civil.
     * @param identifiant L'identifiant unique du civil.
     */
    public Civil(String planète_origine , String motif_voyage , String nom , String prenom , String identifiant){
        super(nom , prenom , identifiant);
        this.planète_origine = planète_origine ;
        this.motif_voyage = motif_voyage ;
    }



    /**
     * Retourne la planète d'origine du civil.
     *
     * @return La planète d'origine du civil.
     */
    public String getPlanète_origine() {
        return planète_origine;
    }




    /**
     * Retourne le motif du voyage du civil.
     *
     * @return Le motif du voyage.
     */
    public String getMotif_voyage() {
        return motif_voyage;
    }




    /**
     * Modifie la planète d'origine du civil.
     *
     * @param planète_origine La nouvelle planète d'origine.
     */
    public void setPlanète_origine(String planète_origine) {
        this.planète_origine = planète_origine;
    }




    /**
     * Modifie le motif du voyage du civil.
     *
     * @param motif_voyage Le nouveau motif du voyage.
     */
    public void setMotif_voyage(String motif_voyage) {
        this.motif_voyage = motif_voyage;
    }



    /**
     * Retourne une description textuelle complète du civil, incluant :
     * son nom, prénom, identifiant, planète d'origine et motif du voyage.
     *
     * @return Une chaîne de caractères contenant la description complète du civil.
     */
    @Override
    public String getDescription(){
        return "Civil : " + getNom() + " " + getPrenom() + " " + getIdentifiant() + " " + getPlanète_origine() + " " + getMotif_voyage() ;
    }
    





}

