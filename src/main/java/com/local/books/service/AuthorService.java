package com.local.books.service;

import com.local.books.domain.Author;
import com.local.books.entities.AuthorEntity;
import com.local.books.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void addAuthor(Author author) {
        authorRepository.save(Author.toEntity(Optional.ofNullable(author)));
    }

    public Author getAuthor(Long id) {
        return Author.fromEntity(authorRepository.findById(id));
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll().stream()
                .map(authorEntity -> Author.fromEntity(Optional.ofNullable(authorEntity)))
                .collect(Collectors.toList());
    }

    public List<Author> getAuthorsByFirstName(String firstName) {
        return authorRepository.findByFirstName(firstName).stream()
                .map(authorEntity -> Author.fromEntity(Optional.ofNullable(authorEntity)))
                .collect(Collectors.toList());
    }

    public List<Author> getAuthorsByFirstNameLike(String firstName) {
        return authorRepository.findByFirstNameLike(firstName).stream()
                .map(authorEntity -> Author.fromEntity(Optional.ofNullable(authorEntity)))
                .collect(Collectors.toList());
    }

    /*public List<Author> getAuthorsByFirstOrLastName(String firstName) {
        return authorRepository.findByFirstNameLikeOrLastNameLikeOrOrderByFirstName(firstName).stream()
                .map(authorEntity -> Author.fromEntity(Optional.ofNullable(authorEntity)))
                .collect(Collectors.toList());
    }*/

    public List<Author> getAuthorsByFirstNameNotLike(String firstName) {
        return authorRepository.findByFirstNameNotLike(firstName).stream()
                .map(authorEntity -> Author.fromEntity(Optional.ofNullable(authorEntity)))
                .collect(Collectors.toList());
    }

}