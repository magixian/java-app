package com.local.books.repositories;

import com.local.books.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    List<AuthorEntity> findByFirstName(String firstName);

    List<AuthorEntity> findByFirstNameLike(String firstName);

    //List<AuthorEntity> findByFirstNameLikeOrLastNameLikeOrOrderByFirstName(String firstName);

    List<AuthorEntity> findByFirstNameNotLike(String firstName);

}