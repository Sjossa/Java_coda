package exercice_J3.personnages;

import exercice_J3.tools.Functions;

public class Guerrier extends Personnage {

    private int armure;
    private float esquive;


  public Guerrier(String nom, int force, int vie, int armure, float esquive, Race race) {
    super(nom, "Guerrier", force, vie, race);
    this.armure = Math.max(1, Math.min(armure, 5));
    this.esquive = Math.max(0f, Math.min(esquive, 0.5f));
}


    @Override
     public float getEsquive() {
        return esquive;
    }

    @Override
    public void attaque(Personnage cible) {
        int modif = Functions.alea(-3, 3);
        int degats = Math.max(0, force + modif);
         if (Functions.aleaFloat(0f, 1f) < cible.getEsquive()) {
                System.out.println(getNom() + " esquive l'attaque !");
                return;
            }

        cible.subirDegats(degats);

        System.out.println(nom + " attaque " + cible.nom +
                " → " + degats + " dégâts | Vie restante : " + cible.vie);
    }

    @Override
    public String fiche() {
        return super.fiche() +
                " - Armure : " + armure + " points\n" + " - Esquive : " + esquive + " points\n";
    }
}
