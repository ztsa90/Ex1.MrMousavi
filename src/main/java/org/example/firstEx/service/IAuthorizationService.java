package org.example.firstEx.service;

import org.example.firstEx.model.Authorization;

import java.util.List;

public interface IAuthorizationService {
    Authorization save(Authorization authorization);

    List<Authorization> getAll();

    Authorization getById(Long id);
    void delete(Authorization authorization);
    //Authorization update(Authorization authorization);
    Authorization update(Authorization authorization);
}
