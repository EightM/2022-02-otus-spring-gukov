package hw02.model;

public class Person {
  private final String name;
  private final String lastName;

  public Person(String name, String lastName) {
    this.name = name;
    this.lastName = lastName;
  }

  public String name() {
    return name;
  }

  public String lastName() {
    return lastName;
  }

  @Override
  public String toString() {
    return lastName + " " + name;
  }
}
