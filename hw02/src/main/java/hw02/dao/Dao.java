package hw02.dao;

import java.util.List;

public interface Dao<T> {
  List<T> getAll();
}
