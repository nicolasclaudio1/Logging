import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Library {
    private static final Logger logger = Logger.getLogger(Library.class.getName());
    private Map<String, Book> books = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        logger.info("Livro adicionado ao acervo: " + book.getTitle());
    }

    public void addMember(Member member) {
        members.put(member.getId(), member);
        logger.info("Membro cadastrado: " + member.getId());
    }

    public void checkoutBook(String memberId, String isbn) {
        Member member = members.get(memberId);
        Book book = books.get(isbn);

        if (member == null || book == null) {
            logger.warning("Falha no empréstimo: Dados inválidos");
            return;
        }

        if (!book.isAvailable()) {
            logger.warning("Falha no empréstimo: Livro indisponível - " + book.getTitle());
            return;
        }

        book.setAvailable(false);
        member.borrowBook(book);
        logger.info("Empréstimo realizado: " + book.getTitle() + " para " + member.getId());
    }

    public void returnBook(String memberId, String isbn) {
        Member member = members.get(memberId);
        Book book = books.get(isbn);

        if (member == null || book == null) {
            logger.warning("Falha na devolução: Dados inválidos");
            return;
        }

        book.setAvailable(true);
        member.returnBook(book);
        logger.info("Devolução realizada: " + book.getTitle() + " por " + member.getId());
    }
}