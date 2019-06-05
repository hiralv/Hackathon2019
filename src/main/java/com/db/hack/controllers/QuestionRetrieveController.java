package com.db.hack.controllers;

import com.db.hack.beans.Question;
import com.db.hack.beans.Student;
import com.db.hack.beans.StudentRegistration;
import com.db.hack.data.retrieval.QuestionsRetrieval;
import com.db.hack.databse.DatabaseConnectionFactory;
import com.db.hack.json.JsonData;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class QuestionRetrieveController {
	
	@RequestMapping(method = RequestMethod.GET, value="/questions")
	@ResponseBody
	public String getQuestions() {
		String finalQuestion = "";
		DatabaseConnectionFactory dc = new DatabaseConnectionFactory("team7User", "HAckCaryTeam7");
		QuestionsRetrieval questionsRetrieval = new QuestionsRetrieval(dc);
		List<Question> questionList = questionsRetrieval.getAllQuestions();
		System.out.println("===-->> "+questionList.size());
		JsonData jsondata = new JsonData();
		try {
			finalQuestion = jsondata.getQuestionsJson(questionList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return finalQuestion;
	}

	@RequestMapping(method = RequestMethod.GET, value="/test")
	@ResponseBody
	public String getTest() {
		String finalQuestion = "";
		DatabaseConnectionFactory dc = new DatabaseConnectionFactory("team7User", "HAckCaryTeam7");
		QuestionsRetrieval questionsRetrieval = new QuestionsRetrieval(dc);
		List<Question> questionList = questionsRetrieval.getAllQuestions();
		System.out.println("===-->> "+questionList.size());
		JsonData jsondata = new JsonData();
		try {
			finalQuestion = jsondata.getQuestionsJson(questionList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return finalQuestion;
	}
}
