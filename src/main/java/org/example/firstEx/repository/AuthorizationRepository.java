package org.example.firstEx.repository;

import org.example.firstEx.model.Authorization;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationRepository extends PagingAndSortingRepository<Authorization,Long> {
}
