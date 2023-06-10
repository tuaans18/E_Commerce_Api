package com.shoes.store.sevice;

import com.shoes.store.repository.entity.Users;

import java.util.List;

public interface UserService {

    Users findByEmail(String email);

    boolean existsByEmail(String email);

    Users saveUser(Users user);

    List<Users> findAllUser();
}
