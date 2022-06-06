package org.example.firstEx.service;

import org.example.firstEx.model.Group;

import java.util.List;

public interface IGroupService {
    Group save(Group group);
    List<Group>getAll();
    Group getById(Long id);
    void deleteAll();
    void delete(Group group);
    Group update(Group group);
}
