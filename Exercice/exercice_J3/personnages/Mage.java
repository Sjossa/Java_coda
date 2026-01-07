package exercice_J3.personnages;


import exercice_J3.tools.Functions;

public class Mage extends Personnage {

    private int mana;
    private float esquive;

    public Mage(String nom, int force, int vie, int mana, float esquive, Race race) {
        super(nom, "Mage", force, vie, race);
        this.mana = Math.max(50, Math.min(mana, 100));
        this.esquive = Math.max(0f, Math.min(esquive, 0.5f));
    }

    @Override
     public float getEsquive() {
        return esquive;
    }

    @Override
    public void attaque(Personnage cible) {

        if (mana < 10) {
            System.out.println(getNom() + " n'a plus assez de mana !");

            int modif = Functions.alea(-2, 2);
            int degats = Math.max(0, force / 2 + modif);
            if (Functions.aleaFloat(0f, 1f) < cible.getEsquive()) {
                System.out.println(getNom() + " esquive l'attaque !");
                return;
            }
            cible.subirDegats(degats);

            System.out.println(getNom() + " attaque physiquement " +
                    cible.getNom() + " → " + degats +
                    " dégâts | Vie restante : " + cible.getVie());
            return;
        }

        int puissanceMagique = Functions.alea(10, 30);
        int modif = Functions.alea(-5, 5);
        int degats = Math.max(0, puissanceMagique + modif);

        mana -= 10;
        cible.subirDegats(degats);

        System.out.println(getNom() + " lance un sort sur " +
                cible.getNom() + " → " + degats +
                " dégâts | Vie restante : " + cible.getVie());
    }

    @Override
    public String fiche() {
        return super.fiche() +
                " - Mana : " + mana + " points\n";
    }
}
