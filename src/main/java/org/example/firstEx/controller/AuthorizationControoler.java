package org.example.firstEx.controller;


import org.example.firstEx.model.Authorization;
import org.example.firstEx.service.AuthorizationService;
import org.example.firstEx.service.IAuthorizationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authorization")
public class AuthorizationControoler {

    IAuthorizationService authorizationService;

    public AuthorizationControoler(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PutMapping(value = "/save")
    public Authorization saving(@RequestBody Authorization authorization) {
        return authorizationService.save(authorization);
    }

    @GetMapping(value = "/get")
    public List<Authorization> getting() {
        return authorizationService.getAll();
    }

    @GetMapping(value = "/getById")
    public Authorization getByID(@PathVariable Long id)
    {
        return authorizationService.getById(id);
    }
    @DeleteMapping(value = "/delete")
    public void delete(Authorization authorization)
    {
        authorizationService.delete(authorization);
    }

    @PostMapping(value="/update")
            public Authorization update(@RequestBody Authorization authorization)
    {
        return authorizationService.update(authorization);
    }
}
