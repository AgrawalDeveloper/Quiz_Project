package com.quiz.QuizService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.QuizService.Services.QuizServices;
import com.quiz.QuizService.entities.Quiz;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizServices quizService;
	
	@PostMapping
	public Quiz createQuiz(@RequestBody Quiz quiz)
	{
		return quizService.add(quiz);
		
	}
	@GetMapping("/")
	public List<Quiz> get()
	{
		return quizService.get();
	}
	
	@GetMapping("/{id}")
	public Quiz get(@PathVariable Long id)
	{
		return quizService.get(id);
	}

}
