package org.example.service;

import org.example.model.Book;

import java.util.List;
import java.util.Optional;

public interface LibraryService {
    void addBook(String title, String author, int year, String isbn);
    void removeBook(String isbn);
    List<Book> findBooksByTitle(String title);
    List<Book> findBooksByAuthor(String author);
    List<Book> findBooksByYear(int year);
    Optional<Book> findBookByIsbn(String isbn);
    List<Book> getAllBooks();
}