package com.springjwt.apijwt.repositories;

import com.springjwt.apijwt.rds_entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByUid(String uid);
}
