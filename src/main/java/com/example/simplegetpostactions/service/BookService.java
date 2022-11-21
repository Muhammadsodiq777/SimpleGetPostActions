package com.example.simplegetpostactions.service;

import com.example.simplegetpostactions.dto.BookDto;
import com.example.simplegetpostactions.entity.Book;

import java.util.List;

public interface BookService {
    Book getBookById(Long id) throws Exception;

    List<Book> getAll() throws Exception;

    Book saveBook(BookDto dto);

    Book updateBook(Long id, BookDto dto) throws Exception;

    String deleteBook(Long id) throws Exception;
}
