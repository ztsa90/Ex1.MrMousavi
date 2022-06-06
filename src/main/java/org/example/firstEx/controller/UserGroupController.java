package org.example.firstEx.controller;

import org.example.firstEx.model.UserGroup;
import org.example.firstEx.service.IUserGroupService;
import org.example.firstEx.service.UserGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/userGroups")
@RestController
public class UserGroupController {

    IUserGroupService userGroupService;
    public UserGroupController(UserGroupService userGroupServiceService) {
        this.userGroupService = userGroupServiceService;
    }

    @PostMapping(value="/add")
    public UserGroup saving(@RequestBody UserGroup userGroup)
    {
        return userGroupService.save(userGroup);
    }

    @GetMapping(value="/get")
    public List<UserGroup> gettAll()
    {return userGroupService.getAll();}

    @GetMapping(value = "/getById")
    public UserGroup getting(@PathVariable Long id)
    {return userGroupService.getById(id);}

    @DeleteMapping(value="/delete")
    public void delete(@RequestBody UserGroup userGroup)
    {
        userGroupService.delete(userGroup);
    }

    public UserGroup update(@RequestBody UserGroup userGroup)
    {
        return userGroupService.update(userGroup);
    }

}
