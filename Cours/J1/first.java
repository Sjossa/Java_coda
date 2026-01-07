//fonctionnement = java <nom du fichier>
package J1;
public class first{

    public static void main(String[] args){
        System.out.println("bonjour le monde");

     
        int nombre;

        int a;
        int A;

        nombre = 5;
        int nb = 5;
        short somme = (short) (nombre + nb);
        System.out.println(somme);
        float reel;
        double Reel;
        reel = (float) 2.5;
        Reel = (double) 2.75;
        reel = (float) Reel;


        String chaine;
        chaine = "jojo";
        System.out.println(chaine);

        System.out.println(chaine + " " + reel);
    }
}
