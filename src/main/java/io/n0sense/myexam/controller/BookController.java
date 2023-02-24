package io.n0sense.myexam.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.n0sense.myexam.entity.Book;
import io.n0sense.myexam.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String list(Integer page, Model model) {
        page = page == null ? 1 : page;
        Page<Book> paging = PageHelper.startPage(page, 10);
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        model.addAttribute("bookPage", paging);
        return "list";
    }
}
