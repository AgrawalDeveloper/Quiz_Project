package com.quiz.QuizService.Services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.QuizService.entities.Question;

@FeignClient(url="http://localhost:8084", value="Question-client")
public interface QuestionClient {
	
	@GetMapping("/question/quiz/{quizId}")
	public List<Question> getQuestioOfQuiz(@PathVariable Long quizId);

}
