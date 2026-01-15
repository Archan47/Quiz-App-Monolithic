package com.microservices.quizapp.services;

import com.microservices.quizapp.entity.Question;
import com.microservices.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;


    public List<Question> getAllQuestions() {

        return questionDao.findAll();

    }

    // Topic categorization
    public List<Question> getQuestionsByCategory(String category) {

        return questionDao.findByCategory(category);
    }

    // Level categorization
    public List<Question> getLevelWiseQuestions(String category,String difficultyLevel) {

        return questionDao.findByCategoryAndDifficultyLevel(category,difficultyLevel);
    }

    // add question (Admin)
    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success";
    }
}