package src;
class Book {
    String title;
    String author;
    int nbpages;

    Book(String title, String author, int nbpages) {
        this.title = title;
        this.author = author;
        this.nbpages = nbpages;
    }
}

public class poo_base {
    public static void main(String[] args) {
        Book mybook = new Book("harry", "potter", 250);
        System.out.println("Title: " + mybook.title);
    }
}
