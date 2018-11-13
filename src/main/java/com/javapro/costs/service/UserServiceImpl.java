package com.javapro.costs.service;

import com.javapro.costs.model.User;
import com.javapro.costs.repository.datajpa.DataJpaUserRepository;
import com.javapro.costs.util.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private final DataJpaUserRepository repository;

  public UserServiceImpl(DataJpaUserRepository repository) {
    this.repository = repository;
  }

  @Override
  public User get(long id) throws NotFoundException {
    return repository.findOne(id);
  }

  @Override
  public User save(User user) throws NotFoundException {
    return repository.save(user);
  }

  @Override
  public List<User> getAll() {
    return repository.findAll();
  }

  @Override
  public void delete(long id) {
    repository.delete(id);
  }
}
