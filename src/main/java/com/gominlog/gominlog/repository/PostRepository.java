package com.gominlog.gominlog.repository;

import com.gominlog.gominlog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
