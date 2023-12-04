package com.feedverse.authenticator.repository;

import com.feedverse.authenticator.model.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBUserRepository extends JpaRepository<DBUser, String> {

}
