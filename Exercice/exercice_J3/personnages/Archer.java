
package exercice_J3.personnages;

import exercice_J3.tools.Functions;

public class Archer extends Guerrier {

    private int attaqueDistance;
    private float esquive;
    private int armure;

    public Archer(String nom, int force, int vie, int armure, float esquive, int attaqueDistance, Race race) {
        super(nom, force, vie, armure, esquive, race);
        this.attaqueDistance = Math.max(5, Math.min(attaqueDistance, 20));
    }

    @Override
    public float getEsquive() {
        return esquive;
    }

    @Override
    public void attaque(Personnage cible) {
        int modif = Functions.alea(-3, 3);
        int chanceToucher = Functions.alea(50, 100);

        if (Functions.alea(0, 100) < chanceToucher) {
            System.out.println(getNom() + " touche la cible !");
        } else {
            System.out.println(getNom() + " rate son attaque !");
        }

        int degats = Math.max(0, force + attaqueDistance + modif);

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
