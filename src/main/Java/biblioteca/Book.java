import java.util.logging.Logger;

public class Book {
    private static final Logger logger = Logger.getLogger(Book.class.getName());
    private String isbn;
    private String title;
    private String author;
    private boolean available;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
        logger.info("Livro criado: " + title);
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) {
        this.available = available;
        logger.info("Status de '" + title + "' atualizado para: " + (available ? "Disponível" : "Indisponível"));
    }
}