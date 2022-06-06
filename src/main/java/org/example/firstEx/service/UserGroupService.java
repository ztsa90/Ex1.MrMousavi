package org.example.firstEx.service;


import org.example.firstEx.model.UserGroup;
import org.example.firstEx.repository.UserGroupRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserGroupService implements IUserGroupService {
    public UserGroupRepository userGroupRepository;

    public UserGroupService(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    @Override
    public UserGroup save(UserGroup userGroup) {
        return userGroupRepository.save(userGroup);
    }

    @Override
    public List<UserGroup> getAll() {
        return (List<UserGroup>) userGroupRepository.findAll();
    }

    @Override
    public UserGroup getById(Long id) {
        Optional<UserGroup> optionalUserGroup = userGroupRepository.findById(id);
        if (optionalUserGroup.isEmpty()) {
            throw new NotFoundException("There is no id.");
        }
        return optionalUserGroup.get();
    }

    @Override
    public void delete(UserGroup userGroup) {
        userGroupRepository.delete(userGroup);
    }


    @Override
    public UserGroup update(UserGroup userGroup) {

        Long lastUserGroupId = userGroup.getUserId();
        Optional<UserGroup> optionalUpdate1 = userGroupRepository.findById(lastUserGroupId);
        if (optionalUpdate1.isEmpty())
        {
            throw new NotFoundException("there is no id.");
        }
        UserGroup lastUserGroup = getById(lastUserGroupId);

        Long newId =userGroup.getUserId();
        Long newGroupId = userGroup.getGroupId();
        Boolean newActive = userGroup.getActive();


        lastUserGroup .setUserId(newId);
        lastUserGroup.setGroupId(newGroupId);
        lastUserGroup.setActive(newActive);
        UserGroup newUserGroup=userGroupRepository.save(lastUserGroup);
        return newUserGroup;

    }
}
