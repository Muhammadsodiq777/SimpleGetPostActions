package com.example.simplegetpostactions.repository;

import com.example.simplegetpostactions.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
