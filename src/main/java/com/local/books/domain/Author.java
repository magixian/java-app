package com.local.books.domain;

import com.local.books.entities.AuthorEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@Builder
public class Author {

    Long id;
    String firstName;
    String lastName;

    public Author(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Author fromEntity(Optional<AuthorEntity> authorEntity) {
        return authorEntity.map(authorEntity1 -> Author.builder()
                .id(authorEntity1.getId())
                .firstName(authorEntity1.getFirstName())
                .lastName(authorEntity1.getLastName())
                .build()).orElse(null);
    }

    public static AuthorEntity toEntity(Optional<Author> author) {
        return author.map(author1 -> AuthorEntity.builder()
                .id(author1.getId())
                .firstName(author1.getFirstName())
                .lastName(author1.getLastName())
                .build()).orElse(null);
    }
}