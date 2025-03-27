package main.java.fr.starfleet.modele.vaisseau;
import java.util.ArrayList;
import java.util.List;
import main.java.fr.starfleet.modele.mission.Mission;


public class Vaisseau {
    private String nom;
    private String immatriculation;
    public int capaciteMaximale;
    public List<Mission> missions ;


    public Vaisseau(String nom, String immatriculation, int capaciteMaximale) {
        this.nom = nom ;
        this.immatriculation = immatriculation ;
        this.capaciteMaximale = capaciteMaximale ;

    }

    public int getCapaciteMaximale() {
        return capaciteMaximale;
    }

    public String getNom() {
        return nom;
    }

    public String getImmatriculation() {
        return immatriculation;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    public void setCapaciteMaximale(int capaciteMaximale) {
        this.capaciteMaximale = capaciteMaximale;
    }

    public void ajouterMission(Mission mission){

        if (mission == null) {
            System.out.println("Mission invalide : elle est null.");
            return;
        }

        if (missions == null) {
            missions = new ArrayList<>(); // Initialiser la liste si elle est null
        }

        // Vérifier si la mission est déjà assignée
        if (missions.contains(mission)) {
            System.out.println("Cette mission est déjà assignée à ce vaisseau.");
            return;
        }

        // Ajouter la mission à la liste
        missions.add(mission);
        System.out.println("Mission ajoutée avec succès : " + mission.getCode());
    }


    public List<Mission> getMissions(){
        return missions ;
    }


}
