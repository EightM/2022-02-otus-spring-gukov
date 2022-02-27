package ru.otus.gukov.hw01.service;

import ru.otus.gukov.hw01.dao.Dao;
import ru.otus.gukov.hw01.model.Question;

import java.util.List;

public class DefaultQuestionService implements QuestionService {

  private final Dao<Question> questionDao;

  public DefaultQuestionService(Dao<Question> questionDao) {
    this.questionDao = questionDao;
  }

  @Override
  public List<Question> getAllQuestions() {
    return questionDao.getAll();
  }
}
