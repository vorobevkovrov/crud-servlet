package repository;

import entity.Task;

public interface TaskRepo {
    Task getById(int id);

    void add(Task task);

    void update(Task task);

    void delete(Task task);
}
