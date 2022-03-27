package com.example.Bcrypt.Repository;

import com.example.Bcrypt.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
