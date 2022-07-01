package com.eszigeti.actionmonitor.repository;

import com.eszigeti.actionmonitor.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}