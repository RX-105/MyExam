package io.n0sense.myexam.service;

import io.n0sense.myexam.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
}
