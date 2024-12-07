package com.hsvd.notesapp.service;

import com.hsvd.notesapp.entity.User;

public interface UserService {
    
    User findUserById(Long id);
    User findUserByUsername(String username);
    void createUser(User user);

}
