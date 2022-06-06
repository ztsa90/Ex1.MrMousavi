package org.example.firstEx.service;


import org.example.firstEx.model.Group;
import org.example.firstEx.repository.GroupRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service

public class GroupService implements IGroupService {
    public GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public List<Group> getAll() {
        return (List<Group>) groupRepository.findAll();
    }

    @Override
    public Group getById(Long id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isEmpty()) {
            throw new NotFoundException("this group is not found");
        }
        return optionalGroup.get();

    }

    @Override
    public void deleteAll() {
        groupRepository.deleteAll();
    }

    @Override
    public void delete(Group group) {
        groupRepository.delete(group);
    }

    @Override
    public Group update(Group group) {
        Long lastId=group.getId();
        Optional<Group> optionalUpdate = groupRepository.findById(lastId);
        if (optionalUpdate.isEmpty()) {
            throw new NotFoundException("the id in not found.");
        }
        Group lastSavedGroup = getById(lastId);
        Long newId=group.getId();
        String newName=group.getName();
        Boolean newActive=group.getActive();

        lastSavedGroup.setId(newId);
        lastSavedGroup.setName(newName);
        lastSavedGroup.setActive(newActive);

        Group newGroup=groupRepository.save(lastSavedGroup);
        return newGroup;

    }
}

