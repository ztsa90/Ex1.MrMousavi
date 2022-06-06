package org.example.firstEx.service;

import org.example.firstEx.model.User;

import java.util.List;

public interface IUserService {
 public User save(User user);
 public List<User> getAll();
 public User getById(Long id);
 void delete(User user);
 User update(User user);

}
