package com.question.QuestionService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/{questionId}")
	public Question getQuestion(@PathVariable Long questionId)
	{
		return this.questionService.getQuestion(questionId);
	}
	
	@GetMapping("/")
	public List<Question> getAllQuestion()
	{
		return this.questionService.getAllQuestions();
	}
	
	@PostMapping("/")
	public Question createQuestion(@RequestBody Question question)
	{
		return this.questionService.createQuestion(question);
	}
	
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuesionOfQuiz(@PathVariable Long quizId)
	{
		return questionService.getQuestionsOfQuiz(quizId);
	}
	
	

}
