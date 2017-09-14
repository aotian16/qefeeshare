package com.qefee.qefeeshare.service;

import com.qefee.qefeeshare.entity.PostPO;
import com.qefee.qefeeshare.entity.dobj.PostDO;
import com.qefee.qefeeshare.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<PostDO> getPostByStatus(
            String status,
            Pageable pageable) {
        Page<PostPO> postsByStatus = postRepository.getPostsByStatus(status, pageable);
        return postsByStatus.map(PostDO::new);
    }

    public PostPO save(PostPO post) {
        return postRepository.save(post);
    }
}
