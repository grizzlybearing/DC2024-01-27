package com.example.restapplication.repository;

import com.example.restapplication.entites.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    boolean existsByLogin (String login);
    @Query("SELECT story.user FROM Story story WHERE story.id = :storyId")
    User findUserByStory(@Param("storyId") Long storyId);
    Page<User> findAll(Pageable pageable);
}
