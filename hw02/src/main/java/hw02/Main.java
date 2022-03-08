package hw02;

import hw02.model.Question;
import hw02.service.ExamService;
import hw02.service.QuestionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext("hw02");
    var examService = context.getBean(ExamService.class);

    var examResult = examService.startExam();
    System.out.println(examResult);
  }
}
