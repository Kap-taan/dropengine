package com.hsvd.notesapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hsvd.notesapp.entity.User;
import com.hsvd.notesapp.exceptions.UserNotFoundException;
import com.hsvd.notesapp.repository.UserRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class UserServiceImpl implements UserService  {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return unwrappedUser(user, username);
    }

    @Override
    public void createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    private User unwrappedUser(Optional<User> user, String username) {
        if(user.isPresent())
            return user.get();
        throw new UserNotFoundException(username);
    }
    
}
