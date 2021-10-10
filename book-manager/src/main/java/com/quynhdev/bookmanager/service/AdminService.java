package com.quynhdev.bookmanager.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.quynhdev.bookmanager.model.Admin;

public interface AdminService {

    boolean checkLogin(String username, String password);

    void deleteAll();

    void deleteAll(List<Admin> entities);

    void delete(Admin entity);

    void deleteById(Long id);

    long count();

    List<Admin> findAllById(List<Long> ids);

    List<Admin> findAll();

    boolean existsById(Long id);

    Optional<Admin> findById(Long id);

    List<Admin> saveAll(List<Admin> entities);

    Admin save(Admin entity);

    Admin findByUsername(String username);

    int calculateAge(Admin entity);

}
