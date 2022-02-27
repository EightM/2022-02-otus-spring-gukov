package ru.otus.gukov.hw01.dao;

import java.util.List;

public interface Dao<T> {
  List<T> getAll();
}
