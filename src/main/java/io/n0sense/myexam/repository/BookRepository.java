package io.n0sense.myexam.repository;

import io.n0sense.myexam.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    int save(Book book);
    void deleteById(Long id);
    Optional<Book> findById(Long id);
    List<Book> findAll();
}
