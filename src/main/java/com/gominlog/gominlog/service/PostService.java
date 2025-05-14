package com.gominlog.gominlog.service;

import com.gominlog.gominlog.domain.Post;
import com.gominlog.gominlog.dto.PostDto;
import com.gominlog.gominlog.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public void save(PostDto dto) {
        Post post = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .author("익명")
                .build();
        System.out.println("게시글 :" + dto.getTitle());
        postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }
}
