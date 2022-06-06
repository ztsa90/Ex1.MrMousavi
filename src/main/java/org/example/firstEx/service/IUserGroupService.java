package org.example.firstEx.service;

import org.example.firstEx.model.UserGroup;

import java.util.List;

public interface IUserGroupService {

    UserGroup save(UserGroup userGroup);

    List<UserGroup> getAll();
    UserGroup getById(Long id);
    void delete(UserGroup userGroup);
    UserGroup update(UserGroup userGroup);

}
