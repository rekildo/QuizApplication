package com.rekildo.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rekildo.quizapp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

	List<Question> findByCategory(String category);

	//native query
	@Query(value="SELECT * from question q where q.category=:category ORDER BY RAND() LIMIT :numQ",nativeQuery=true)
	List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
