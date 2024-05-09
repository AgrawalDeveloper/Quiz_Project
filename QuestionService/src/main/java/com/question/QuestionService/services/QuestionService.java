package com.question.QuestionService.services;

import java.util.List;

import com.question.QuestionService.entities.Question;

public interface QuestionService {
	
	public Question getQuestion(Long questionId);
	
	public List<Question> getAllQuestions();
	
	public Question createQuestion(Question question);
	
	public List<Question> getQuestionsOfQuiz(Long quizId);

}
