package com.springframework.spring5webapp.controller;

import com.springframework.spring5webapp.model.Book;
import com.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model)
    {
        Iterable<Book> bks =  bookRepository.findAll();
        model.addAttribute("books", bks);
        return "books";
    }
}
