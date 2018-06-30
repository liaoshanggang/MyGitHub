package com.forward.spring.boot.blog.repository;

import com.forward.spring.boot.blog.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{

}
