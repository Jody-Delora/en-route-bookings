package com.enRoute.demo.repository;

import com.enRoute.demo.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author JODY
 */
public interface UserRepository extends CrudRepository<User, Long>{
    User findByEmail1(String email1);
}

