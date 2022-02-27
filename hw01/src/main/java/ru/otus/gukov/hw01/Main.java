package ru.otus.gukov.hw01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.gukov.hw01.model.Question;
import ru.otus.gukov.hw01.service.QuestionService;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    var context = new ClassPathXmlApplicationContext("context.xml");
    var questionService = context.getBean(QuestionService.class);

    printQuestions(questionService.getAllQuestions());
  }

  private static void printQuestions(List<Question> questions) {
    questions.stream()
      .map(Object::toString)
      .forEach(System.out::println);
  }
}
