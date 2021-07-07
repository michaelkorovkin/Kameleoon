package com.kameleoon.test.model.repos;

import com.kameleoon.test.model.dto.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
