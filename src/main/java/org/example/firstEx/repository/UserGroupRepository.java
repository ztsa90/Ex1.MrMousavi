package org.example.firstEx.repository;

import org.example.firstEx.model.User;
import org.example.firstEx.model.UserGroup;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepository extends PagingAndSortingRepository<UserGroup,Long> {
}
