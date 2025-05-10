import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Member {
    private static final Logger logger = Logger.getLogger(Member.class.getName());
    private String id;
    private String name;
    private List<Book> borrowedBooks;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
        logger.info("Novo membro registrado: " + name);
    }

    public String getId() { return id; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        logger.info("Livro emprestado: " + book.getTitle() + " para " + name);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        logger.info("Livro devolvido: " + book.getTitle() + " por " + name);
    }
}