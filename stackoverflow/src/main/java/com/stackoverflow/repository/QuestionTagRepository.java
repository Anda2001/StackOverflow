package com.stackoverflow.repository;

import com.stackoverflow.entity.QuestionTag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTagRepository extends CrudRepository<QuestionTag, Long> {
}
