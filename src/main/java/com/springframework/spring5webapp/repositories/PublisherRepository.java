package com.springframework.spring5webapp.repositories;

import com.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
