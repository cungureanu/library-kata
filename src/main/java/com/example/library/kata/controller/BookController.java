package com.example.library.kata.controller;

import com.example.library.kata.persistence.Book;
import com.example.library.kata.repository.BookRepository;
import com.example.library.kata.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("books")
public class BookController {

    final private BookService bookService;
    final private BookRepository bookRepository;

    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
        loadData();
    }

    @PostMapping
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping(path = "/all")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping(path = "/{bookId}/user/{userId}/borrow")
    public Optional<Book> borrowBook(@PathVariable Long bookId, @PathVariable Long userId) {
        return bookService.borrowBook(bookId, userId);
    }

    @PostMapping(path = "/{bookId}/user/{userId}/return")
    public Optional<Book> returnBook(@PathVariable Long bookId, @PathVariable Long userId) {
        return bookService.returnBook(bookId, userId);
    }

    @GetMapping(path = "/user/{userId}/borrowed")
    public List<Book> getBooksByBorrowById(@PathVariable Long userId) {
        return bookService.getBooksByBorrowById(userId);
    }

    private void loadData() {
        var books = List.of(
                new Book("Airborne", null),
                new Book("The Stand", null),
                new Book("I Am Legend", null)
        );

        bookRepository.saveAll(books);
    }

}
