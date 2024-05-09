package com.question.QuestionService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.repositories.QuestionRepository;



@Service
public class QuestionServiceImpl implements QuestionService {

	private QuestionRepository questionRepository;

	public QuestionServiceImpl(QuestionRepository repo)
	{
		this.questionRepository=repo;
	}
	@Override
	public Question getQuestion(Long questionId) {
		return this.questionRepository.findById(questionId).orElseThrow(()->new RuntimeException("Question is not found! Please create"));
	}

	@Override
	public List<Question> getAllQuestions() {
		return this.questionRepository.findAll();
	}

	@Override
	public Question createQuestion(Question question) {
		return this.questionRepository.save(question);
	}
	@Override
	public List<Question> getQuestionsOfQuiz(Long quizId) {
		return this.questionRepository.findByQuizId(quizId);
	}

}
