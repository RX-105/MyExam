package io.n0sense.myexam.repository;

import io.n0sense.myexam.entity.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookMapper {
    @Select("select * from book")
    @Results(id = "bookMapping", value = {
            @Result(property = "b_id", column = "b_id"),
            @Result(property = "b_name", column = "b_name"),
            @Result(property = "b_author", column = "b_author"),
            @Result(property = "b_price", column = "b_price"),
            @Result(property = "b_press", column = "b_press")
    })
    List<Book> findAll();
}
