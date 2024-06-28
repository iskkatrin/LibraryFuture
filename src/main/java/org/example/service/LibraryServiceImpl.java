package org.example.service;

import org.example.model.Book;
import org.example.model.Library;

import java.util.List;
import java.util.Optional;

public class LibraryServiceImpl implements LibraryService {
    private Library library;

    public LibraryServiceImpl(Library library) {
        this.library = library;
    }

    @Override
    public void addBook(String title, String author, int year, String isbn) {
        Book book = new Book(title, author, year, isbn);
        library.addBook(book);
    }

    @Override
    public void removeBook(String isbn) {
        library.removeBook(isbn);
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        return library.findBooksByTitle(title);
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        return library.findBooksByAuthor(author);
    }

    @Override
    public List<Book> findBooksByYear(int year) {
        return library.findBooksByYear(year);
    }

    @Override
    public Optional<Book> findBookByIsbn(String isbn) {
        return library.findBookByIsbn(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return library.getAllBooks();
    }
}