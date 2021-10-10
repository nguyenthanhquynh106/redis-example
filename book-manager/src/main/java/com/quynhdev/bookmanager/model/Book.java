package com.quynhdev.bookmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String detail;
    private Integer count;
    private String photo;

    public Book(String name, String detail, Integer count, String image) {
        this.name = name;
        this.detail = detail;
        this.count = count;
        this.photo = image;
    }
}
