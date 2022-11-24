package peaksoft.repository;

import peaksoft.model.Task;

import java.util.List;

public interface TaskRepository {

    List<Task> getAllTasks(Long id);

    void saveTask(Task task,Long id);     // lesson id

    void updateTask(Task task,Long id);   //lesson id

    void deleteTask(Long id);             // task id

    Task getTaskById(Long id);
}
