package com.springjwt.apijwt.rdsrepositories;

import com.springjwt.apijwt.rdsentities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByUid(String uid);
}
