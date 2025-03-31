# starfleet-reservation-system
## Developpeur : Emmmanuel Kadiebwe B2 CMS
Lien du depots : https://github.com/Hendrix44/starfleet-reservation-system.git

Commande pour compliler le projet (Attention fonctionne uniquemment sur MAC cette methode de compilation):
```bash 
  javac -d bin $(find . -name "*.java")
```

Pour executer le projet:
```bash
  java -cp bin main.java.fr.starfleet.Main
```

![Description de l'image](image/*.png)
### Description du projet
#### Fonctionalitées Implementées

**1. Classe InterfaceConsole** 
gère l’interaction avec l’utilisateur via une interface en ligne de commande. Elle contient un menu principal permettant d’accéder aux fonctionnalités du système.

demarrer() : Boucle principale qui affiche le menu et attend l’entrée de l’utilisateur.
afficherMenu() : Affiche les différentes options du menu.
gererVaisseaux() : Menu de gestion des vaisseaux (ajout, suppression, affichage).
gererPersonnes() : Menu de gestion des personnes (ajout, suppression, affichage).
gererMissions() : Menu de gestion des missions (ajout, suppression, affichage).
gererReservations() : Menu de gestion des réservations (création, suppression, affichage).
sauvegarderDonnees(String fichier) : Sauvegarde l’état du système dans un fichier.
chargerDonnees(String fichier) : Charge les données d’un fichier et restaure l’état du système.

**2. Classe SystemeReservation** 

C est le cœur du programme. Elle stocke et gère les vaisseaux, les personnes, les missions et les réservations.

**3. Classe Vaisseau (Gestion des Vaisseaux)**

 Représente un vaisseau spatial dans la flotte Starfleet.


**4. Classe Personne (Superclasse des Civils et Officiers)**

Représente un individu qui peut participer à une mission.


**5. Classe Mission (Gestion des Missions Spatiales)**

 Définit une mission et assigne un vaisseau.


**6. Classe Reservation (Gestion des Réservations de Mission)**

 Gère l’inscription des passagers aux missions spatiales.



### Probleme rencontré 

lors de la conception du project par manque d'inadvertance de ma part j'ai perdu beaucoup de temps sur la methode de sauvegarde et de chargement de fichier sachant qu'il etait a notre disposition sur le  pdf.
Tout le code fonctionne sans probleme excepté l'affichage des reservations completes et le chargement de la sauvegarde.