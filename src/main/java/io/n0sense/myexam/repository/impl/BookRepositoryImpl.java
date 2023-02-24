package io.n0sense.myexam.repository.impl;

import io.n0sense.myexam.entity.Book;
import io.n0sense.myexam.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BookRepositoryImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Book book) {
        if (book.getB_id() == null) {
            // insert new
            return jdbcTemplate.update("insert into book(b_name, b_author, b_price, b_press) values (?, ?, ?, ?)",
                    book.getB_name(), book.getB_author(), book.getB_price(), book.getB_press());
        } else {
            // update existing
            return jdbcTemplate.update("update book set b_name=?, b_author=?, b_price=?, b_press=? where b_id=?",
                    book.getB_name(), book.getB_author(), book.getB_price(), book.getB_press(), book.getB_id());
        }
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("delete from book where b_id=?", id);
    }

    @Override
    public Optional<Book> findById(Long id) {
        Book book = jdbcTemplate.queryForObject("select * from book where b_id=?",
                new BeanPropertyRowMapper<>(Book.class), id);
        return Optional.ofNullable(book);
    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("select * from book",
                new BeanPropertyRowMapper<>(Book.class));
    }
}
