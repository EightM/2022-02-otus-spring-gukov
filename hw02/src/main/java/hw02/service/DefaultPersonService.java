package hw02.service;

import hw02.model.Person;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class DefaultPersonService implements PersonService {
  @Override
  public Person askCredentials() {
    var scanner = new Scanner(System.in);
    System.out.println("Please enter your name");
    var name = scanner.nextLine();
    System.out.println("Please enter your last name");
    var lastName = scanner.nextLine();

    return new Person(name, lastName);
  }
}
