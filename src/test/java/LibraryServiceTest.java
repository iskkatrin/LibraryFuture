import org.example.model.Book;
import org.example.model.Library;
import org.example.service.LibraryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryServiceTest {

    private LibraryServiceImpl service;

    @BeforeEach
    void setUp() {
        Library library = new Library();
        service = new LibraryServiceImpl(library);
    }

    @Test
    void testAddBook() {
        service.addBook("Test Book", "Test Author", 2023, "1234567890");
        List<Book> books = service.getAllBooks();
        assertEquals(1, books.size());
        assertEquals("Test Book", books.get(0).getTitle());
    }

    @Test
    void testRemoveBook() {
        service.addBook("Test Book", "Test Author", 2023, "1234567890");
        service.removeBook("1234567890");
        assertTrue(service.getAllBooks().isEmpty());
    }

    @Test
    void testFindBooksByTitle() {
        service.addBook("Java Basics", "John Doe", 2020, "9876543210");
        service.addBook("Advanced Java", "Jane Smith", 2021, "5678901234");

        List<Book> foundBooks = service.findBooksByTitle("Java");
        assertEquals(2, foundBooks.size());
    }

    @Test
    void testFindBookByIsbn() {
        service.addBook("Java Basics", "John Doe", 2020, "9876543210");
        Optional<Book> foundBook = service.findBookByIsbn("9876543210");
        assertTrue(foundBook.isPresent());
        assertEquals("Java Basics", foundBook.get().getTitle());
    }
}