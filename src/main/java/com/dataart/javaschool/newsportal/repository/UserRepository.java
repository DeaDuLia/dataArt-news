package com.dataart.javaschool.newsportal.repository;


import com.dataart.javaschool.newsportal.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByLOGIN (String LOGIN);
}
