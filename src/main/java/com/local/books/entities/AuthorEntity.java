package com.local.books.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Tolerate;

import javax.persistence.*;

@Builder
@Entity
@Table(name = "Authors")
@Getter
@Setter
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String firstName;
    String lastName;

    @Tolerate
    public AuthorEntity() {}
}