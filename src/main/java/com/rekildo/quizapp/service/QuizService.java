package com.rekildo.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rekildo.quizapp.dao.QuestionDao;
import com.rekildo.quizapp.dao.QuizDao;
import com.rekildo.quizapp.model.Question;
import com.rekildo.quizapp.model.Quiz;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;

	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);

		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(questions);
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Sucess", HttpStatus.CREATED);
	}
	
	
}
