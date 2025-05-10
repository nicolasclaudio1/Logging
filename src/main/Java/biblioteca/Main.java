import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Configuração do Logger
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.ALL);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        rootLogger.addHandler(handler);

        // Demonstração
        Library library = new Library();

        Book book1 = new Book("978-0544003415", "O Senhor dos Anéis", "J.R.R. Tolkien");
        Book book2 = new Book("978-8535914849", "1984", "George Orwell");
        library.addBook(book1);
        library.addBook(book2);

        Member member = new Member("M001", "Ana Silva");
        library.addMember(member);

        library.checkoutBook("M001", "978-0544003415");
        library.returnBook("M001", "978-0544003415");
    }
}
