package hw02.model;

import java.util.Collection;
import java.util.stream.Collectors;

public class Question {
  private final String text;
  private final Collection<AnswerOption> answerOptions;
  private final int rightAnswer;

  public Question(String text, Collection<AnswerOption> answerOptions, int rightAnswer) {
    this.text = text;
    this.rightAnswer = rightAnswer;
    this.answerOptions = answerOptions;
  }

  public String text() {
    return text;
  }

  public int rightAnswer() {
    return rightAnswer;
  }

  public Collection<AnswerOption> answerOptions() {
    return answerOptions;
  }

  @Override
  public String toString() {
    return text + "\n" + formatAnswerOptions();
  }

  private String formatAnswerOptions() {
    return answerOptions.stream()
      .map(Object::toString)
      .collect(Collectors.joining("/"));
  }
}
