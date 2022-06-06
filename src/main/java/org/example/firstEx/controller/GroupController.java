package org.example.firstEx.controller;


import org.example.firstEx.model.Group;
import org.example.firstEx.service.GroupService;
import org.example.firstEx.service.IGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    IGroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PutMapping(value = "/add")
    public Group saving(@RequestBody Group group) {
        return groupService.save(group);
    }

    @GetMapping(value = "/getAll")
    public List<Group> getAll() {
        return groupService.getAll();
    }
    @GetMapping(value = "/getById")
    public Group getById(@PathVariable Long id)
    {
        return groupService.getById(id);
    }
   @DeleteMapping(value = "/deleteAll")
    public void deleteAll(){
        groupService.deleteAll();
   }

   @DeleteMapping(value = "/delete")
           public void delete(@RequestBody Group group)
   {
       groupService.delete(group);
   }
   @PostMapping(value = "/update")
           public Group update(@RequestBody Group group)
   { return groupService.update(group);
       }
}
