package com.hsvd.notesapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hsvd.notesapp.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
