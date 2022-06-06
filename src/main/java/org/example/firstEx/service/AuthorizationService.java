package org.example.firstEx.service;

import org.example.firstEx.model.Authorization;
import org.example.firstEx.repository.AuthorizationRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorizationService implements IAuthorizationService {
    AuthorizationRepository authorizationRepository;

    public AuthorizationService(AuthorizationRepository authorizationRepository) {
        this.authorizationRepository = authorizationRepository;
    }

    @Override
    public Authorization save(Authorization authorization) {
        return authorizationRepository.save(authorization);
    }

    @Override
    public List<Authorization> getAll() {
        return (List<Authorization>) authorizationRepository.findAll();
    }

    @Override
    public Authorization getById(Long id1) {
        Optional<Authorization> optionalAut1 = authorizationRepository.findById(id1);
        if (optionalAut1.isEmpty()) {
            throw new NotFoundException("the id is not found.");
        }
        return optionalAut1.get();
    }

    @Override
    public void delete(Authorization authorization) {

        authorizationRepository.delete(authorization);

    }

    @Override
    public Authorization update(Authorization authorization) {

        Long lastId = authorization.getId();

        Optional<Authorization> optionalAuthorization = authorizationRepository.findById(lastId);
        if (optionalAuthorization.isEmpty()) {
            throw new NotFoundException("no id.");
        }
        Authorization lastAuthorization = getById(lastId);

        Long newId = authorization.getId();
        Boolean newActive = authorization.getActive();
        String newSource=authorization.getSource();

        Authorization newAuthorization = authorizationRepository.save(lastAuthorization);
        return newAuthorization;
    }


}
