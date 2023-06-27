package com.example.simplegetpostactions.controller;

import com.example.simplegetpostactions.dto.BookDto;
import com.example.simplegetpostactions.entity.Book;
import com.example.simplegetpostactions.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping("/get/book/{id}")
    public ResponseEntity<?> getAllBooks(@PathVariable Long id) {
        try {
            Book bookById = service.getBookById(id);
            return ResponseEntity.ok(bookById);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
        }
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getBookById() {
        try {
            List<Book> books = Arrays.asList(
                    new Book(1L, "No Name", "Me", LocalDateTime.now()),
                    new Book(2L, "No Named", "Me", LocalDateTime.now()),
                    new Book(3L, "No Names", "Me", LocalDateTime.now()),
                    new Book(4L, "No Namer", "Me", LocalDateTime.now()),
                    new Book(5L, "No Namee", "Me", LocalDateTime.now()));
            return ResponseEntity.ok(books);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveBook(@RequestBody BookDto dto) {
        try {
            Book book = service.saveBook(dto);
            return ResponseEntity.ok().body(book);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
        }
    }

    @PutMapping("/update/book/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookDto dto) {
        try {
            Book book = service.updateBook(id, dto);
            return ResponseEntity.ok().body(book);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.deleteBook(id);
            return ResponseEntity.ok().body("Deleted");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
        }
    }
}
