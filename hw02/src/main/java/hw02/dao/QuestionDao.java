package hw02.dao;

import hw02.model.AnswerOption;
import hw02.model.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class QuestionDao implements Dao<Question> {

  private final String pathToCsvFile;

  public QuestionDao(@Value("${app.questions}") String pathToCsvFile) {
    this.pathToCsvFile = pathToCsvFile;
  }

  @Override
  public List<Question> getAll() {
    return readQuestionsFromFile();
  }

  private List<Question> readQuestionsFromFile() {
    List<Question> result = new ArrayList<>();

    try (var inputStream = new ClassPathResource(pathToCsvFile).getInputStream()) {
      var reader = new BufferedReader(new InputStreamReader(inputStream));
      var questionRows = readAndSplitQuestions(reader);

      for (var row : questionRows) {
        var answerVariants = createAnswerVariantsFromRow(row);
        int rightAnswer = Integer.parseInt(row.get(1));
        var question = new Question(row.get(0), answerVariants, rightAnswer);
        result.add(question);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }

  private List<AnswerOption> createAnswerVariantsFromRow(List<String> row) {
    return row.subList(2, row.size())
      .stream()
      .map(AnswerOption::new)
      .collect(Collectors.toList());
  }

  private List<List<String>> readAndSplitQuestions(BufferedReader reader) {
    return reader.lines()
      .map(s -> Arrays.asList(s.split(",")))
      .collect(Collectors.toList());
  }
}
