package com.quynhdev.bookmanager.service;

import com.quynhdev.bookmanager.model.Admin;
import com.quynhdev.bookmanager.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceIpml implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin save(Admin entity) {
        return adminRepository.save(entity);
    }

    @Override
    public List<Admin> saveAll(List<Admin> entities) {
        return adminRepository.saveAll(entities);
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return adminRepository.existsById(id);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public List<Admin> findAllById(List<Long> ids) {
        return adminRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return adminRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public void delete(Admin entity) {
        adminRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<Admin> entities) {
        adminRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        adminRepository.deleteAll();
    }

    @Override
    public boolean checkLogin(String username, String password) {
        Admin admin = adminRepository.findByUsername(username);
        return admin != null && admin.getPassword().equals(password);
    }

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public int calculateAge(Admin entity) {
        LocalDate now = LocalDate.now();
        return Period.between(entity.getBirthday(), now).getYears();
    }
}
