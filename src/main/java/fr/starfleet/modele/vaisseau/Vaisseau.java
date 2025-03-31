package main.java.fr.starfleet.modele.vaisseau;
import java.util.ArrayList;
import java.util.List;
import main.java.fr.starfleet.modele.mission.Mission;
import java.io.Serializable;

/**
 * La classe Vaisseau représente un vaisseau spatial avec des informations telles que le nom, l'immatriculation,
 * la capacité maximale du vaisseau, et les missions qui lui sont assignées.
 */
public class Vaisseau implements Serializable{
    private String nom;
    private String immatriculation;
    public int capaciteMaximale;
    public List<Mission> missions ;

    /**
     * Constructeur pour initialiser un vaisseau.
     *
     * @param nom Le nom du vaisseau.
     * @param immatriculation L'immatriculation du vaisseau.
     * @param capaciteMaximale La capacité maximale du vaisseau (le nombre de missions qu'il peut gérer).
     */
    public Vaisseau(String nom, String immatriculation, int capaciteMaximale) {
        this.nom = nom ;
        this.immatriculation = immatriculation ;
        this.capaciteMaximale = capaciteMaximale ;

    }


    /**
     * Obtient la capacité maximale du vaisseau.
     *
     * @return La capacité maximale du vaisseau.
     */
    public int getCapaciteMaximale() {
        return capaciteMaximale;
    }


    /**
     * Obtient le nom du vaisseau.
     *
     * @return Le nom du vaisseau.
     */
    public String getNom() {
        return nom;
    }


    /**
     * Obtient l'immatriculation du vaisseau.
     *
     * @return L'immatriculation du vaisseau.
     */
    public String getImmatriculation() {
        return immatriculation;
    }

    /**
     * Définit le nom du vaisseau.
     *
     * @param nom Le nom à définir.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Définit l'immatriculation du vaisseau.
     *
     * @param immatriculation L'immatriculation à définir.
     */
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    /**
     * Définit la capacité maximale du vaisseau.
     *
     * @param capaciteMaximale La capacité maximale à définir.
     */
    public void setCapaciteMaximale(int capaciteMaximale) {
        this.capaciteMaximale = capaciteMaximale;
    }


    /**
     * Ajoute une mission au vaisseau. Si la mission est déjà assignée ou si la mission est invalide,
     * elle ne sera pas ajoutée.
     *
     * @param mission La mission à ajouter au vaisseau.
     */
    public void ajouterMission(Mission mission){

        if (mission == null) {
            System.out.println("Mission invalide : elle est null.");
            return;
        }

        if (missions == null) {
            missions = new ArrayList<>();
        }


        if (missions.contains(mission)) {
            System.out.println("Cette mission est déjà assignée à ce vaisseau.");
            return;
        }


        missions.add(mission);
        System.out.println("Mission ajoutée avec succès : " + mission.getCode());
    }

    /**
     * Obtient la liste des missions assignées à ce vaisseau.
     *
     * @return La liste des missions.
     */
    public List<Mission> getMissions(){
        return missions ;
    }


    /**
     * Retourne une représentation sous forme de chaîne de caractères du vaisseau, incluant son nom et son immatriculation.
     *
     * @return La chaîne de caractères représentant le vaisseau.
     */
    @Override
    public String toString() {
        return "Vaisseau{nom='" + nom + "', immatriculation='" + immatriculation + "'}";
    }




}
