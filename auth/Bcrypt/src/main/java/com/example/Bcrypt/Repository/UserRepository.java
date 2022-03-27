package com.example.Bcrypt.Repository;

import com.example.Bcrypt.Model.UserPost;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.function.Function;

@Repository
public interface UserRepository extends JpaRepository<UserPost,Long> {
    UserPost findByusername(String username);
}
