package com.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsbExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsbExamApplication.class, args);
//
//		Answer a = new Answer();
//
//		//자바 방식
//		Question question = a.getQuestion();
//		question.getContent();
//		a.getQuestion().getContent();

		//특정 질문에 달린 모든 답글들
		//DB 방식
		//Question q1 = questionRepository.findById(1);
		//answerRepository.findByQuestionId(q1.getId()) // 특정 질문에 달린 답변들

		// 자바 방식
		//Question q1 = questionRepository.findById(1);
		//q1.getAnswerList();
	}



}