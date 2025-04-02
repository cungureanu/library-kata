package com.example.library.kata.repository;

import com.example.library.kata.persistence.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> getBookByIdAndBorrowedBy(Long id, Long borrowedBy);

    List<Book> getBooksByBorrowedBy(Long borrowedBy);

}
