package com.rekildo.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.rekildo.quizapp.dao.QuestionDao;
import com.rekildo.quizapp.dao.QuizDao;
import com.rekildo.quizapp.model.Question;
import com.rekildo.quizapp.model.QuestionWrapper;
import com.rekildo.quizapp.model.Quiz;
import com.rekildo.quizapp.model.Response;

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

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionsFromDB = quiz.get().getQuestion();
		List<QuestionWrapper> questionsForUser = new ArrayList<>();
		
		for(Question q : questionsFromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsForUser.add(qw);
		}
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Quiz quiz = quizDao.findById(id).get();
		List<Question> question = quiz.getQuestion();
		
		int right = 0;
		int i = 0;
		for(Response response : responses) {
			if(response.getResponse().equals(question.get(i).getRightAnswer())) {
				right++;
			}
			i++;
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}
	
	
	
}
