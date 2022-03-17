package hw02;

import hw02.service.ExamService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext("hw02");
    var examService = context.getBean(ExamService.class);

    examService.startExam();
  }
}
