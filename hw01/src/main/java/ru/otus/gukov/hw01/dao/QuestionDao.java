package ru.otus.gukov.hw01.dao;

import org.springframework.core.io.ClassPathResource;
import ru.otus.gukov.hw01.model.AnswerOption;
import ru.otus.gukov.hw01.model.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionDao implements Dao<Question> {

  private final String pathToCsvFile;

  public QuestionDao(String pathToCsvFile) {
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
        var question = new Question(row.get(0), answerVariants);
        result.add(question);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }

  private List<AnswerOption> createAnswerVariantsFromRow(List<String> row) {
    return row.subList(1, row.size())
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
