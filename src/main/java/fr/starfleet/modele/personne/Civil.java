package main.java.fr.starfleet.modele.personne;

public class Civil extends Personne {
    private String planète_origine ;
    private String motif_voyage ;




    public Civil(String planète_origine , String motif_voyage , String nom , String prenom , String identifiant){
        super(nom , prenom , identifiant);
        this.planète_origine = planète_origine ;
        this.motif_voyage = motif_voyage ;
    }


    public String getPlanète_origine() {
        return planète_origine;
    }

    public String getMotif_voyage() {
        return motif_voyage;
    }

    public void setPlanète_origine(String planète_origine) {
        this.planète_origine = planète_origine;
    }

    public void setMotif_voyage(String motif_voyage) {
        this.motif_voyage = motif_voyage;
    }

    public String getDescription(){
        return "Civil : " + getNom() + " " + getPrenom() + " " + getIdentifiant() + " " + getPlanète_origine() + " " + getMotif_voyage() ;
    }
    





}

