package com.gominlog.gominlog.service;

import com.gominlog.gominlog.domain.Post;
import com.gominlog.gominlog.dto.PostDto;
import com.gominlog.gominlog.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public void save(PostDto dto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = auth.getName();

        Post post = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .author(currentUsername)
                .build();
        System.out.println("게시글 :" + dto.getTitle());
        postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    public void update(Long id, PostDto dto, String username) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setAuthor(username);
    }
}
