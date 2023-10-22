package com.rekildo.quizapp.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rekildo.quizapp.dao.QuestionDao;
import com.rekildo.quizapp.model.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		
		try {
			return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e);
		}
			//returning empty arrayList
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e);
		}
			//returning empty arrayList
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		}
		

	public ResponseEntity<String> addQuestion(Question question) {
		questionDao.save(question);
		return new ResponseEntity<>("data inserted ! daymm", HttpStatus.CREATED);
	}

}
