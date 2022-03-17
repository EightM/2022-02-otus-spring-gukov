package hw02.service;

import hw02.model.ExamResult;
import hw02.model.Person;
import hw02.model.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class DefaultExamService implements ExamService {

  private final QuestionService questionService;
  private final PersonService personService;
  private final int passScore;

  public DefaultExamService(QuestionService questionService, PersonService personService, @Value("${app.passScore}") int passScore) {
    this.questionService = questionService;
    this.personService = personService;
    this.passScore = passScore;
  }

  @Override
  public void startExam() {
    Person person = personService.askCredentials();
    var examResult =  askQuestions(person, questionService.getAllQuestions());
    System.out.println(examResult);
  }

  private ExamResult askQuestions(Person person, List<Question> questions) {
    var scanner = new Scanner(System.in);
    int rightAnswersCount = 0;

    for (var question : questions) {
      System.out.println("Ask the question by entering answer number (0/1)");
      System.out.println(question);

      int answer = Integer.parseInt(scanner.nextLine());
      if (answer == question.rightAnswer()) {
        rightAnswersCount += 1;
      }
    }

    var isPassed = rightAnswersCount >= passScore;
    return new ExamResult(person, questions.size(), rightAnswersCount, isPassed);
  }
}
