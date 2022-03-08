package ru.otus.gukov.hw01.model;

import java.util.Collection;

public class Question {
  private final String text;
  private final Collection<AnswerOption> answerOptions;

  public Question(String text, Collection<AnswerOption> answerOptions) {
    this.text = text;
    this.answerOptions = answerOptions;
  }

  public String text() {
    return text;
  }

  public Collection<AnswerOption> answerOptions() {
    return answerOptions;
  }

  @Override
  public String toString() {
    return "Question{" +
      "text='" + text + '\'' +
      ", answerOptions=" + answerOptions +
      '}';
  }
}
