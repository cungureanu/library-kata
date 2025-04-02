package com.example.library.kata.persistence;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "borrowed_by")
    private Long borrowedBy;

    public Book(String name, Long borrowedBy) {
        this.name = name;
        this.borrowedBy = borrowedBy;
    }

    public Book(Long id, String name, Long borrowedBy) {
        this.id = id;
        this.name = name;
        this.borrowedBy = borrowedBy;
    }
}
