package hw02.model;

public class ExamResult {
  private final Person person;
  private final int questionsCount;
  private final int correctAnswerCount;
  private final boolean isPassed;

  public ExamResult(Person person, int questionsCount, int correctAnswerCount, boolean isPassed) {
    this.person = person;
    this.questionsCount = questionsCount;
    this.correctAnswerCount = correctAnswerCount;
    this.isPassed = isPassed;
  }

  @Override
  public String toString() {
    String result = "Exam result" + "\n" +
      "Person: " + person.toString() + "\n" +
      "Questions asked: " + questionsCount + "\n" +
      "Right answers: " + correctAnswerCount + "\n";

    if (isPassed) {
      result += "Exam passed";
    } else {
      result += "Exam failed";
    }

    return result;
  }
}
