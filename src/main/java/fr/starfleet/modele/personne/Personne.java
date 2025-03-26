package main.java.fr.starfleet.modele.personne;

public abstract class Personne {


    private String nom;
    private String prenom;
    private String identifiant;


    public Personne (String nom , String prenom , String identifiant){
        this.nom = nom ;
        this.prenom = prenom ;
        this.identifiant = identifiant ;
    }

    public String getNom() {
        return nom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public abstract String getDescription();

    


    
}
