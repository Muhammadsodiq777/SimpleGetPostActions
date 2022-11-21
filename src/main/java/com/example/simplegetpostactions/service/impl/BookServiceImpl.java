package com.example.simplegetpostactions.service.impl;

import com.example.simplegetpostactions.dto.BookDto;
import com.example.simplegetpostactions.entity.Book;
import com.example.simplegetpostactions.repository.BookRepository;
import com.example.simplegetpostactions.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book getBookById(Long id) throws Exception {
        Optional<Book> byId = bookRepository.findById(id);
        if(!byId.isPresent())
            throw new Exception("Bunday kitob topilmadi");
        return byId.get();
    }
    @Override
    public List<Book> getAll() throws Exception {
        List<Book> all = bookRepository.findAll();
        if(all.isEmpty())
            throw new Exception("Kitoblar mavjud emas");
        return all;
    }

    @Override
    public Book saveBook(BookDto dto){
        Book book = new Book();
        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        book.setCreated_at(LocalDateTime.now());
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id,BookDto dto) throws Exception {
        Optional<Book> byId = bookRepository.findById(id);
        if(!byId.isPresent())
            throw new Exception("Bunday kitob topilmadi");
        Book book = byId.get();
        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        book.setCreated_at(LocalDateTime.now());
        return bookRepository.save(book);
    }

    @Override
    public String deleteBook(Long id) throws Exception {
        Optional<Book> byId = bookRepository.findById(id);
        if(!byId.isPresent())
            throw new Exception("Bunday kitob topilmadi");
        Book book = byId.get();
        bookRepository.deleteById(book.getId());
        return "Muvaffaqqiyatli o'chirildi";
    }
}
