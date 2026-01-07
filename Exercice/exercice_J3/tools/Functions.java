package exercice_J3.tools;

import java.util.Random;
import java.util.Scanner;

import exercice_J3.personnages.Archer;
import exercice_J3.personnages.Guerrier;
import exercice_J3.personnages.Mage;
import exercice_J3.personnages.Personnage;
import exercice_J3.personnages.Voleur;

public class Functions {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static int alea(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static float aleaFloat(float min, float max) {
        return random.nextFloat() * (max - min) + min;
    }

    public static int saisieInt(String message) {
        int valeur;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                valeur = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Ce n'est pas un nombre !");
                scanner.next();
            }
        }
        return valeur;
    }

    public static float saisieFloat(String message) {
        float valeur;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextFloat()) {
                valeur = scanner.nextFloat();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Ce n'est pas un nombre !");
                scanner.next();
            }
        }
        return valeur;
    }

    public static int verifieValeur(int valeur, int min, int max, String message) {
        while (valeur < min || valeur > max) {
            System.out.println("Valeur invalide ! " + message);
            valeur = saisieInt(message);
        }
        return valeur;
    }

    public static float verifieValeurFloat(float valeur, float min, float max, String message) {
        while (valeur < min || valeur > max) {
            System.out.println("Valeur invalide ! " + message);
            valeur = saisieFloat(message);
        }
        return valeur;
    }

    public static Personnage creerPersonnage() {
        int type = saisieInt("Type (1 = Guerrier, 2 = Mage , 3 = Archer), 4 : ");
        while (type != 1 && type != 2 && type != 3 && type != 4) {
            type = saisieInt("Type invalide ! Tapez 1 pour Guerrier, 2 pour Mage, 3 pour Archer ou 4 pour Voleur : ");
        }

        System.out.print("Nom : ");
        String nom = scanner.nextLine();

        int force, armure, mana, attaqueDistance, vie, race;
        float esquive;
        Personnage.Race racechoisi;

        switch (type) {
            case 1:
                vie = verifieValeur(saisieInt("Vie (120-200) : "), 120, 200, "Vie (120-200)");
                force = verifieValeur(saisieInt("Force (12-20) : "), 12, 20, "Force (12-20)");
                armure = verifieValeur(saisieInt("Armure (3-5) : "), 3, 5, "Armure (3-5)");
                esquive = verifieValeurFloat(saisieFloat("Esquive (0.05-0.25) : "), 0.05f, 0.25f,
                        "Esquive (0.05-0.25)");
                race = verifieValeur(saisieInt("Race (0-5) : "), 0, 5, "Race (0-5)");
                racechoisi = Personnage.Race.values()[race];

                return new Guerrier(nom, force, vie, armure, esquive, racechoisi);

            case 2:
                vie = verifieValeur(saisieInt("Vie (60-120) : "), 60, 120, "Vie (60-120)");
                force = verifieValeur(saisieInt("Force (1-8) : "), 1, 8, "Force (1-8)");
                mana = verifieValeur(saisieInt("Mana (120-200) : "), 120, 200, "Mana (120-200)");
                esquive = verifieValeurFloat(saisieFloat("Esquive (0.10-0.35) : "), 0.10f, 0.35f,
                        "Esquive (0.10-0.35)");
                race = verifieValeur(saisieInt("Race (0-5) : "), 0, 5, "Race (0-5)");
                racechoisi = Personnage.Race.values()[race];

                return new Mage(nom, force, vie, mana, esquive, racechoisi);

            case 3:
                vie = verifieValeur(saisieInt("Vie (80-150) : "), 80, 150, "Vie (80-150)");
                force = verifieValeur(saisieInt("Force (8-15) : "), 8, 15, "Force (8-15)");
                armure = verifieValeur(saisieInt("Armure (1-3) : "), 1, 3, "Armure (1-3)");
                attaqueDistance = verifieValeur(saisieInt("Attaque distance (10-20) : "), 10, 20,
                        "Attaque distance (10-20)");
                esquive = verifieValeurFloat(saisieFloat("Esquive (0.20-0.45) : "), 0.20f, 0.45f,
                        "Esquive (0.20-0.45)");
                race = verifieValeur(saisieInt("Race (0-5) : "), 0, 5, "Race (0-5)");
                racechoisi = Personnage.Race.values()[race];

                return new Archer(nom, force, vie, armure, esquive, attaqueDistance, racechoisi);

            case 4:
                vie = verifieValeur(saisieInt("Vie (70-130) : "), 70, 130, "Vie (70-130)");
                force = verifieValeur(saisieInt("Force (6-14) : "), 6, 14, "Force (6-14)");
                esquive = verifieValeurFloat(saisieFloat("Esquive (0.30-0.60) : "), 0.30f, 0.60f,
                        "Esquive (0.30-0.60)");
                race = verifieValeur(saisieInt("Race (0-5) : "), 0, 5, "Race (0-5)");
                racechoisi = Personnage.Race.values()[race];

                return new Voleur(nom, force, vie, esquive, racechoisi);

            default:
                return null;
        }
    }

    public static Personnage combat(Personnage joueur, Personnage joueur2) {
        System.out.println("\n--- Début du combat ---\n");

        while (joueur.estVivant() && joueur2.estVivant()) {
            joueur.attaque(joueur2);
            if (!joueur2.estVivant())
                break;
            joueur2.attaque(joueur);
        }

        Personnage vainqueur = joueur.estVivant() ? joueur : joueur2;
        System.out.println("\nVainqueur : " + vainqueur.getNom());
        return vainqueur;
    }

   public static void combatClavier() {
    int choix = saisieInt("Quel mode  essayer ? 1 = VS, 2 = Tournoi : ");

    while (choix != 1 && choix != 2) {
        choix = saisieInt("Mode invalide ! Tapez 1 pour VS ou 2 pour Tournoi : ");
    }

    int nbJoueurs = (choix == 1) ? 2 : 4;
    Personnage[] joueurs = new Personnage[nbJoueurs];

    for (int i = 0; i < nbJoueurs; i++) {
        System.out.println("\nCréation du personnage " + (i + 1));
        joueurs[i] = creerPersonnage();
    }

    if (choix == 1) {
        combat(joueurs[0], joueurs[1]);
    } else {

        Personnage vainqueur1 = combat(joueurs[0], joueurs[1]);
        Personnage vainqueur2 = combat(joueurs[2], joueurs[3]);

        System.out.println("\n--- Finale ---\n");
        Personnage vainqueur3 = combat(vainqueur1, vainqueur2);

        System.out.println("\nGrand Vainqueur du tournoi : " + vainqueur3.getNom());



    }
}}

