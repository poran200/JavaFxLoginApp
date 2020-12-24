package com.mycompany.mydbgui.dao;


import com.mycompany.mydbgui.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends DAO<User, String> {

    User register(User user);
    boolean login(User user);
    @Override
    User save(User user);

    @Override
    User update(User user);

    @Override
    Optional<User> finById(String s);

    @Override
    List<User> findAll();

    @Override
    boolean removeBYId(String s);
}
