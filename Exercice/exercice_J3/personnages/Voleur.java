package exercice_J3.personnages;

import exercice_J3.tools.Functions;

public class Voleur extends Personnage {

    private float esquive;

    public Voleur(String nom, int force, int vie, float esquive, Race race) {
        super(nom, "Voleur", force, vie, race);
        this.esquive = Math.max(0f, Math.min(esquive, 0.5f));
    }

    @Override
    public float getEsquive() {
        return esquive;
    }

    @Override
    public void attaque(Personnage cible) {
        int modif = Functions.alea(-4, 4);
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
                " - Esquive : " + esquive + " points\n";
    }

}




