package  main.java.fr.starfleet.ui;

import  main.java.fr.starfleet.modele.mission.Mission;
import  main.java.fr.starfleet.modele.personne.*;
import  main.java.fr.starfleet.modele.vaisseau.Vaisseau;
import  main.java.fr.starfleet.systeme.SystemeReservation;
import java.io.*;
import java.text.*;
import java.util.*;


/**
 * Classe représentant l'interface en ligne de commande pour la gestion du système de réservation de vaisseaux.
 * Permet à l'utilisateur de gérer des vaisseaux, des personnes, des missions et des réservations.
 */
public class InterfaceConsole {
    private final SystemeReservation systeme;
    private transient final Scanner scanner;

    /**
     * Constructeur de la classe InterfaceConsole.
     * Initialise le système de réservation et le scanner pour lire les entrées de l'utilisateur.
     */
    public InterfaceConsole(){
        this.systeme = new SystemeReservation();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Méthode principale pour démarrer l'interface console.
     * Affiche le menu et permet à l'utilisateur de sélectionner des options pour gérer le système.
     *
     * @throws IOException Exception levée en cas d'erreur de lecture/écriture de fichiers.
     */
    public void demarrer() throws IOException{
        boolean continuer = true;
        while(continuer){
            afficherMenu();
            System.out.println("Choississez une option");
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch(choix){
                case 1:
                    gererVaisseaux();
                    break;
                case 2:
                    gererPersonnes();
                    break;
                case 3:
                    gererMissions();
                    break;
                case 4:
                    gererReservations();
                    break;
                case 5:
                    sauvegarderDonnees("sauvegarde.txt");
                    break;
                case 6:
                    chargerDonnees("sauvegarde.txt");
                    break;
                case 7:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer !");
            }
        }
    }

    /**
     * Méthode pour afficher le menu de l'interface console
     */
    private void afficherMenu(){
        System.out.println("\n----------Menu de gestion de starfleet reservation system----------");
        System.out.println("1. Gérer les vaisseaux");
        System.out.println("2. Gérer les personnes");
        System.out.println("3. Gérer les missions");
        System.out.println("4. Gérer les réservations");
        System.out.println("5. Sauvegarder les données");
        System.out.println("6. Charger les données");
        System.out.println("7. Quittez");
    }

    /**
     * Méthode pour gérer la gestion des vaisseaux.
     * Permet d'afficher, ajouter ou supprimer des vaisseaux.
     */
    private void gererVaisseaux(){
        System.out.println("\n-----Gestion des vaisseaux-----");
        System.out.println("1. Afficher tous les vaisseau");
        System.out.println("2. Ajouter un vaisseau");
        System.out.println("3. Supprimer un vaisseau");
        System.out.println("4. Retour au menu de gestion");
        System.out.println("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine();
        switch (choix) {
            case 1:
                systeme.afficherVaisseaux(systeme.getVaisseaux());
                break;
            case 2:
                System.out.println("Nom du vaisseau : ");
                String nomVaisseau = scanner.nextLine();
                System.out.println("Immatriculation : ");
                String immatriculation = scanner.nextLine();
                System.out.println("Capacité maximale : ");
                int capacite = scanner.nextInt();
                scanner.nextLine();
                Vaisseau nouveauVaisseau = new Vaisseau(nomVaisseau, immatriculation, capacite);
                systeme.ajouterVaisseau(nouveauVaisseau);
                System.out.println("Vaisseau ajouté avec succès");
                break;
            case 3:
                System.out.println("ID du vaisseau à supprimer :");
                String idVaisseau = scanner.nextLine();
                systeme.supprimerVaisseau(idVaisseau);
                break;
            default:
                System.out.println("Choix invalide !");
        }
    }

    /**
     * Méthode pour gérer la gestion des personnes.
     * Permet d'afficher, ajouter ou supprimer des personnes.
     */
    private void gererPersonnes(){
        System.out.println("\n-----Gestion des personnes-----");
        System.out.println("1. Afficher toutes les personnes");
        System.out.println("2. Ajouter une personne");
        System.out.println("3. Supprimer une personne");
        System.out.println("4. Retour au menu de gestion");
        System.out.println("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine();
        switch (choix) {
            case 1:
                systeme.afficherPersonnes(systeme.getPersonnes());
                break;
            case 2:
                System.out.println("Quel type de personne souhaitez-vous ajouter ? : ");
                System.out.println("1. Civil");
                System.out.println("2. Officer");
                System.out.println("Votre choix : ");
                int typePersonne = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nom de la personne : ");
                String nom = scanner.nextLine();
                System.out.println("Prénom de la personne : ");
                String prenom = scanner.nextLine();
                System.out.println("Identifiant de la personne : ");
                String id = scanner.nextLine();
                if(typePersonne==1){
                    System.out.println("Planète d'origine du civil : ");
                    String planeteOrigine = scanner.nextLine();
                    System.out.println("Motif du voyage du civil : ");
                    String motifVoyage = scanner.nextLine();
                    Personne civil = new Civil(planeteOrigine, motifVoyage, nom, prenom, id);
                    systeme.ajouterPersonne(civil);
                    System.out.println("Civil ajouté avec succès");

                }else if(typePersonne==2){
                    System.out.println("Rang de l'officier : ");
                    String rang = scanner.nextLine();
                    System.out.println("Spécialité de l'officier : ");
                    String specialite = scanner.nextLine();
                    Personne officier = new Officier(rang, specialite, nom, prenom, id);
                    systeme.ajouterPersonne(officier);
                    System.out.println("Officier ajouté avec succès");
                }else{
                    System.out.println("Choix invalide");
                }
                break;
            case 3:
                System.out.println("Id de la personne à supprimer : ");
                String idPersonne = scanner.nextLine();
                systeme.supprimerPersonne(idPersonne);
                break;
            default:
                System.out.println("Choix invalide");
        }
    }

    /**
     * Méthode pour gérer la gestion des missions.
     * Permet d'afficher, ajouter ou supprimer des missions.
     */
    private void gererMissions(){
        System.out.println("\n-----Gestion des missions-----");
        System.out.println("1. Afficher toutes les missions");
        System.out.println("2. Ajouter une mission");
        System.out.println("3. Supprimer une mission");
        System.out.println("4. Retour au menu de gestion");
        System.out.println("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine();
        switch(choix){
            case 1:
                systeme.afficherMissions(systeme.getMissions());
                break;
            case 2:
                if(systeme.getVaisseaux().isEmpty()){
                    System.out.println("Aucun vaisseau de disponible pour cette mission. Ajouter un vaisseau d'abord !");
                    return;
                }
                System.out.println("Code de la mission : ");
                String codeMission = scanner.nextLine();
                System.out.println("Description de la mission");
                String descripMission = scanner.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dateDepart = null;
                Date dateRetour = null;
                try{
                    System.out.println("Date de départ de la mission (JJ-MM-AAAA)");
                    String dateDepartStr = scanner.nextLine();
                    dateDepart = sdf.parse(dateDepartStr);
                    System.out.print("Date de retour (JJ-MM-AAAA) : ");
                    String dateRetourStr = scanner.nextLine();
                    dateRetour = sdf.parse(dateRetourStr);
                }catch(ParseException e){
                    System.out.println("Erreur du format de la date : Utilisez le format : JJ-MM-AAAA");
                    return;
                }
                System.out.print("Destination de la mission : ");
                String destination = scanner.nextLine();
                System.out.print("Capacité maximale de la mission : ");
                int capaciteMaximale = scanner.nextInt();
                scanner.nextLine();
                systeme.afficherVaisseaux(systeme.getVaisseaux());
                System.out.print("Choisissez le vaisseau (ID) pour cette mission : ");
                String idVaisseau = scanner.nextLine();
                Vaisseau vaisseauChoisi = systeme.getVaisseauParId(idVaisseau);
                if(capaciteMaximale>vaisseauChoisi.getCapaciteMaximale()){
                    System.out.println("La capacité de la mission dépasse celle du vaisseau. Impossible d'ajouter la mission : il faut réduire le personne ! ");
                    return;
                }
                Mission mission = new Mission(codeMission, descripMission, dateDepart, dateRetour, destination, vaisseauChoisi, capaciteMaximale);
                systeme.creeMission(mission);
                System.out.println("Mission ajoutée !");
                break;
            case 3:
                System.out.println("ID de la mission à supprimer");
                String idMission = scanner.nextLine();
                systeme.supprimerMission(idMission);
                break;
            default:
                System.out.println("Choix invalide");
        }
    }

    /**
     * Méthode pour gérer la gestion des réservations.
     * Permet d'afficher, créer ou supprimer des réservations.
     */
    private void gererReservations(){
        System.out.println("\n===== Gestion des Réservations =====");
        System.out.println("1. Afficher toutes les réservations");
        System.out.println("2. Créer une réservation");
        System.out.println("3. Supprimer une réservation");
        System.out.println("4. Retour au menu principal");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine();
        switch (choix) {
            case 1:
                systeme.afficherReservations(systeme.getReservations());
                break;
            case 2:
                System.out.print("ID de la personne : ");
                String idPersonne = scanner.nextLine();
                Personne personne = systeme.getPersonneParId(idPersonne);
                if(personne ==null){
                    System.out.println("Aucune personne n'a été trouvée avec cette ID. Impossible de créer la réservation");
                    return;
                }
                systeme.effectuerReservation(idPersonne);
                System.out.println("Réservation créée !");
                break;
            case 3:
                System.out.println("ID de la réservation à supprimer : ");
                String idReservation = scanner.nextLine();
                systeme.supprimerReservation(idReservation);
                break;
            default:
                break;
        }
    }

    /**
     * Méthode pour sauvegarder les données dans un fichier
     * @param fichier : fichier où seront sauvegardées les données
     * @throws IOException : exception en cas d'erreur de sauvegarde
     */
    private void sauvegarderDonnees(String fichier) throws IOException{
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))){
            oos.writeObject(systeme);
            System.out.println("Données sauvegardées avec succès !");
        }catch(IOException e){
            System.out.println("Erreur lors de la sauvegarde des données." + e.getMessage());
            throw e;
        }
    }

    /**
     * Méthode pour charger les données depuis un fichier
     * @param fichier : fichier d'où seront chargées les données
     * @return : les données qui étaient stockées dans le fichier
     */
    public static SystemeReservation chargerDonnees(String fichier){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))){
            return (SystemeReservation) ois.readObject();
        }catch(FileNotFoundException e){
            System.out.println("Fichier non trouvé : " + fichier);
        } catch (IOException e) {
            System.out.println("Erreur d'entrée/sortie lors du chargement des données.");
        } catch (ClassNotFoundException e) {
            System.out.println("Classe non trouvée lors de la désérialisation.");
        }
        return null;
    }

}