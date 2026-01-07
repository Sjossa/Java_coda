package src.Heritage;

public class Carre extends FigureGeometrique {
    private long cote;

    public long getCote() {
        return cote;
    }

    public long getPerimetre() {
        return 4 * cote;
    }
}

