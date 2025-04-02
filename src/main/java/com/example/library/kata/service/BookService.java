package com.example.library.kata.service;

import com.example.library.kata.persistence.Book;
import com.example.library.kata.repository.BookRepository;
import com.example.library.kata.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional
    public Optional<Book> borrowBook(Long bookId, Long userId) {
        return bookRepository
                .findById(bookId)
                .flatMap(book -> updateBook(book, userId));
    }

    @Transactional
    public Optional<Book> returnBook(Long bookId, Long userId) {
        return bookRepository
                .getBookByIdAndBorrowedBy(bookId, userId)
                .map(book -> {
                    var bookReturn = new Book(book.getId(), book.getName(), null);
                    return bookRepository.save(bookReturn);
                });
    }

    public List<Book> getBooksByBorrowById(@PathVariable Long userId) {
        return bookRepository.getBooksByBorrowedBy(userId);
    }

    private Optional<Book> updateBook(Book book, Long userId) {
        return userRepository.findById(userId).map(user -> {
            var bookBorrow = new Book(book.getId(), book.getName(), userId);
            return bookRepository.save(bookBorrow);
        });
    }

}
