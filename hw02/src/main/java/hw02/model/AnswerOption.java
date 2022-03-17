package hw02.model;

public class AnswerOption {
  private final String text;

  public AnswerOption(String text) {
    this.text = text;
  }

  public String text() {
    return text;
  }

  @Override
  public String toString() {
    return text;
  }
}
