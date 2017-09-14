package com.qefee.qefeeshare.repository;

import com.qefee.qefeeshare.entity.PostPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostPO, Long> {
    Page<PostPO> getPostsByStatus(String status, Pageable pageable);
}
