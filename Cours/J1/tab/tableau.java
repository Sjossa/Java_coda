package J1.tab;

import java.util.Arrays;

public class tableau {

    String[] semaine = { "lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche" };

    public static void main(String[] args) {
        tableau tab = new tableau();
        for (int i = 0; i < tab.semaine.length; i++) {
            System.out.println(tab.semaine[i]);
        }

        for (int i = tab.semaine.length - 1; i >= 0; i--) {
            System.out.println(tab.semaine[i]);
        }

        String[] nouvelleSemaine = Arrays.stream(tab.semaine)
                .filter(jour -> !jour.equals("mercredi"))
                .toArray(String[]::new);

        for (String jour : nouvelleSemaine) {
            System.out.println(jour);
        }


        

    }

}
