package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);



    User getUserById(Long userId);

    List<User> getAllUserById();

    User updateUser(User user);
    public void deleteUser(Long id);
}
