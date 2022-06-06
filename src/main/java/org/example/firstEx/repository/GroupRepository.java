package org.example.firstEx.repository;

import org.example.firstEx.model.Group;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends PagingAndSortingRepository<Group,Long> {
}
