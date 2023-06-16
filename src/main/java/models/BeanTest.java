package models;

import java.util.ArrayList;
import java.util.List;

public class BeanTest {
    public static void main(String[] args) {
        // Create instances of Album
        Album album1 = new Album();
        album1.setId(1);
        album1.setAlbumName("Thriller");
        album1.setArtistName("Michael Jackson");
        album1.setSales(66);

        Album album2 = new Album();
        album2.setId(2);
        album2.setAlbumName("Back in Black");
        album2.setArtistName("AC/DC");
        album2.setSales(45);

        // Create instances of Author
        Author author1 = new Author();
        author1.setId(1);
        author1.setName("Douglas Adams");

        Author author2 = new Author();
        author2.setId(2);
        author2.setName("Mark Twain");

        // Create instances of Quote
        Quote quote1 = new Quote();
        quote1.setId(1);
        quote1.setContent("The answer to the ultimate question of life, the universe, and everything is 42.");
        quote1.setAuthor(author1);

        Quote quote2 = new Quote();
        quote2.setId(2);
        quote2.setContent("The secret of getting ahead is getting started.");
        quote2.setAuthor(author2);

        // Store multiple instances of Quote in an ArrayList
        List<Quote> quotes = new ArrayList<>();
        quotes.add(quote1);
        quotes.add(quote2);

        // Iterate over the quotes and print their content and author names
        for (Quote quote : quotes) {
            System.out.println("Quote Content: " + quote.getContent());
            System.out.println("Author Name: " + quote.getAuthor().getName());
            System.out.println();
        }
    }
}
