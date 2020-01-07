package com.local.books.controller;

import com.local.books.domain.Author;
import com.local.books.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    AuthorService authorService;

    @GetMapping("/health")
    public String getHealth() {
        return "healthy";
    }

    @PostMapping(value = "/author", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

    @GetMapping("/author/{id}")
    public Author getAuthor(@PathVariable("id") Long id) {
        return authorService.getAuthor(id);
    }

    @GetMapping("/author")
    public List<Author> getAuthor() {
        return authorService.getAuthors();
    }

    @GetMapping("/author/a/{query}")
    public List<Author> getAuthorA(@PathVariable("query") String query) {
        return authorService.getAuthorsByFirstName(query);
    }

    @GetMapping("/author/b/{query}")
    public List<Author> getAuthorB(@PathVariable("query") String query) {
        return authorService.getAuthorsByFirstNameLike(query);
    }

    /*@GetMapping("/author/c/{query}")
    public List<Author> getAuthorC(@PathVariable("query") String query) {
        return authorService.getAuthorsByFirstOrLastName(query);
    }*/

    @GetMapping("/author/d/{query}")
    public List<Author> getAuthorD(@PathVariable("query") String query) {
        return authorService.getAuthorsByFirstNameNotLike(query);
    }

}