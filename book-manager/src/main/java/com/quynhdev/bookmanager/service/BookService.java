package com.quynhdev.bookmanager.service;

import com.quynhdev.bookmanager.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void deleteAll();

    void deleteAll(List<Book> entities);

    void delete(Book entity);

    void deleteById(Long id);

    long count();

    List<Book> findAllById(List<Long> ids);

    Iterable<Book> findAll();

    boolean existsById(Long id);

    Optional<Book> findById(Long id);

    List<Book> saveAll(List<Book> entities);

    Book save(Book entity);

    List<Book> findByNameContaining(String name);

    Page<Book> findPaginated(Pageable pageable);

}
