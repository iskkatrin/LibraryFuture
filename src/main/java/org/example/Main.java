package org.example;

import org.example.model.Library;
import org.example.service.LibraryApp;
import org.example.service.LibraryServiceImpl;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        LibraryServiceImpl service = new LibraryServiceImpl(library);
        LibraryApp app = new LibraryApp(service);
        app.run();
    }
}