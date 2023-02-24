package io.n0sense.myexam.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.n0sense.myexam.entity.Book;
import io.n0sense.myexam.service.BookService;
import io.n0sense.myexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public BookController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
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

    @GetMapping("/login")
    public String getLoginView() {
        return "login";
    }

    @PostMapping("/login")
    public String attemptLogin(String username, String password, Model model) {
        if (userService.checkLogin(username, password)) {
            return "redirect:list";
        } else {
            model.addAttribute("msg", "用户名或密码不正确。");
            return "login";
        }
    }
}
