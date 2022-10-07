package com.gradleproject.demo_gradle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradleproject.demo_gradle.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
}
