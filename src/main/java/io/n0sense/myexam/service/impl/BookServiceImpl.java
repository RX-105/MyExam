package io.n0sense.myexam.service.impl;

import io.n0sense.myexam.entity.Book;
import io.n0sense.myexam.repository.BookMapper;
import io.n0sense.myexam.repository.BookRepository;
import io.n0sense.myexam.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public List<Book> findAll() {
        return bookMapper.findAll();
    }
}
