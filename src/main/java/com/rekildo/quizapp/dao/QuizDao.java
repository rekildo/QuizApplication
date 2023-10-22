package com.rekildo.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rekildo.quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
