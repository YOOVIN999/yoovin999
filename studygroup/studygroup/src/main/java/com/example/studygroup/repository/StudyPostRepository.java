package com.example.studygroup.repository;

import com.example.studygroup.domain.StudyPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyPostRepository extends JpaRepository<StudyPost, Long> {
}