package org.example.service;

import org.example.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class LibraryApp {
    private LibraryServiceImpl service;
    private Scanner scanner;

    public LibraryApp(LibraryServiceImpl service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Search books by title");
            System.out.println("4. Search books by author");
            System.out.println("5. Search books by year");
            System.out.println("6. Search book by ISBN");
            System.out.println("7. Display all books");
            System.out.println("8. Exit");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> searchBooksByTitle();
                case 4 -> searchBooksByAuthor();
                case 5 -> searchBooksByYear();
                case 6 -> searchBookByIsbn();
                case 7 -> displayAllBooks();
                case 8 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        service.addBook(title, author, year, isbn);
        System.out.println("Book added successfully.");
    }

    private void removeBook() {
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = scanner.nextLine();
        service.removeBook(isbn);
        System.out.println("Book removed successfully.");
    }

    private void searchBooksByTitle() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        List<Book> books = service.findBooksByTitle(title);
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private void searchBooksByAuthor() {
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        List<Book> books = service.findBooksByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private void searchBooksByYear() {
        System.out.print("Enter year: ");
        int year = Integer.parseInt(scanner.nextLine());
        List<Book> books = service.findBooksByYear(year);
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private void searchBookByIsbn() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        Optional<Book> book = service.findBookByIsbn(isbn);
        book.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("No book found.")
        );
    }

    private void displayAllBooks() {
        List<Book> books = service.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            books.forEach(System.out::println);
        }
    }
}