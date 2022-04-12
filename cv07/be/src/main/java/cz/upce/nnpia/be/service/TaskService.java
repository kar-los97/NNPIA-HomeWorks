package cz.upce.nnpia.be.service;

import cz.upce.nnpia.be.dto.TaskDto;
import cz.upce.nnpia.be.entity.Task;
import cz.upce.nnpia.be.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task findById(Integer id) {
        return this.taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task nenalezen"));
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Task update(Task task, Integer id){
        Task newTask = taskRepository.findById(id).orElseThrow(()->new RuntimeException("Task nenalezen"));
        newTask.setName(task.getName()!=null?task.getName(): newTask.getName());
        newTask.setComplete(task.isComplete());
        return taskRepository.save(newTask);
    }

    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }
}
