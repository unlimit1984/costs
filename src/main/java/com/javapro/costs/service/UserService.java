package com.javapro.costs.service;


import com.javapro.costs.model.User;
import com.javapro.costs.util.exception.NotFoundException;

import java.util.List;

public interface UserService {

  User get(long id) throws NotFoundException;

  User save(User user) throws NotFoundException;

  List<User> getAll();

  void delete(long id) throws NotFoundException;
}
