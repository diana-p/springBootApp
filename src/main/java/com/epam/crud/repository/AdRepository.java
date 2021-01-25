package com.epam.crud.repository;

import com.epam.crud.models.Ad;
import org.springframework.data.repository.CrudRepository;

public interface AdRepository extends CrudRepository<Ad, Long> {
}
