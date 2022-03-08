package hw02.service;


import hw02.dao.Dao;
import hw02.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
