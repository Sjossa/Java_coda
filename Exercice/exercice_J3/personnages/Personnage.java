package exercice_J3.personnages;

public abstract class Personnage {

    protected String nom;
    protected String metier;
    protected int force;
    protected int vie;

    public enum Race {
        HUMAN, ELF, DWARF, ORC, Gobelin, Hobbit
    }

    protected Race race;

    public Personnage(String nom, String metier, int force, int vie, Race Race) {
        this.nom = nom;
        this.metier = metier;
        this.force = Math.max(1, Math.min(force, 20));
        this.vie = Math.max(50, Math.min(vie, 200));
        this.race = Race;

    }

    public abstract float getEsquive();



    public String getNom() {
        return nom;
    }

    public int getVie() {
        return vie;
    }

    public boolean estVivant() {
        return vie > 0;
    }

    public void subirDegats(int degats) {
        vie = Math.max(0, vie - degats);
    }

    public Race getRace() {
    return race;
}

    public abstract void attaque(Personnage cible);

    public String fiche() {
        return """
                Fiche personnage
                    -Race : %s
                    - Nom : %s
                    - Métier : %s
                    - Force : %d points
                    - Vie : %d points
                    - Armure : %d points
                       - Esquive : %d points
                   """.formatted(nom, metier, force, vie);
    }
}
