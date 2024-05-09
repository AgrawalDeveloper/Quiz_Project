package com.quiz.QuizService.Services;

import java.util.List;

import com.quiz.QuizService.entities.Quiz;

public interface QuizServices {
	
	public Quiz add(Quiz quiz);
	
	public List<Quiz> get();
	
	public Quiz get(Long id);

}
