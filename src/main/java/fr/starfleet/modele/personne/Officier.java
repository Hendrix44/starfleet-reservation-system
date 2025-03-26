package main.java.fr.starfleet.modele.personne;

public class Officier extends Personne  {
    private String rang ;
    private String spécialité ;

    public Officier(String rang , String spécialité , String nom , String prenom , String identifiant){
        super(nom , prenom , identifiant);
        this.rang = rang ;
        this.spécialité = spécialité ;
    }


    public String getRang() {
        return rang;
    }
    
    public String getSpécialité() {
        return spécialité;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public void setSpécialité(String spécialité) {
        this.spécialité = spécialité;
    }

    @Override
    public String getDescription(){
        return "Officier : " + getNom() + " " + getPrenom() + " " + getIdentifiant() + " " + getRang() + " " + getSpécialité() ;
    }
    




}
