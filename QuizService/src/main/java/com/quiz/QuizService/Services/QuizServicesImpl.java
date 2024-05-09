package com.quiz.QuizService.Services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.repositories.QuizRepository;

@Service
public class QuizServicesImpl implements QuizServices{

	private QuizRepository quizRepo;
	
	private QuestionClient questionClient;
	
	
	public QuizServicesImpl(QuizRepository quizRepo, QuestionClient questionClient) {
		super();
		this.quizRepo = quizRepo;
		this.questionClient = questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		return quizRepo.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		 List<Quiz> quizList=quizRepo.findAll();
		 List <Quiz> allQuiz=quizList.stream().map(quiz ->{
			 System.out.println("quiz id : "+quiz.getId());
			 quiz.setQuestionOfQuiz(questionClient.getQuestioOfQuiz(quiz.getId()));
			 return quiz;
		 }).collect(Collectors.toList());
		 return allQuiz;
	}

	@Override
	public Quiz get(Long id) {
		 Quiz quiz=quizRepo.findById(id).orElseThrow(()->new RuntimeException("Quiz not found"));
		 quiz.setQuestionOfQuiz(questionClient.getQuestioOfQuiz(id));
		 return quiz;
	}

}
