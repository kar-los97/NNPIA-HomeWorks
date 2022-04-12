package cz.upce.nnpia.be.controller;

import cz.upce.nnpia.be.dto.TaskDto;
import cz.upce.nnpia.be.entity.Task;
import cz.upce.nnpia.be.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public TaskDto getTaskById(@PathVariable Integer id){
        Task getTask = this.taskService.findById(id);
        TaskDto taskDto = new TaskDto();
        taskDto.setId(getTask.getId());
        taskDto.setName(getTask.getName());
        taskDto.setComplete(getTask.isComplete());
        return taskDto;
    }

    @GetMapping()
    public List<TaskDto> getAllTasks(){
        List<Task> tasks = taskService.findAll();
        List<TaskDto> listTasksDto = new ArrayList<>();
        for(Task task:tasks){
            TaskDto taskDto = new TaskDto();
            taskDto.setId(task.getId());
            taskDto.setName(task.getName());
            taskDto.setComplete(task.isComplete());
            listTasksDto.add(taskDto);
        }
        return listTasksDto;
    }

    @PostMapping()
    public TaskDto createTask(@RequestBody TaskDto task){
        Task taskToProcess = new Task();
        taskToProcess.setId(task.getId());
        taskToProcess.setName(task.getName());
        taskToProcess.setComplete(task.isComplete());

        Task taskCreate =  taskService.save(taskToProcess);

        TaskDto taskDto = new TaskDto();
        taskDto.setId(taskCreate.getId());
        taskDto.setName(taskCreate.getName());
        taskDto.setComplete(taskCreate.isComplete());

        return taskDto;
    }

    @PutMapping("/{id}")
    public TaskDto updateTask(@RequestBody TaskDto task, @PathVariable Integer id){
        Task taskToProcess = new Task();
        taskToProcess.setId(task.getId());
        taskToProcess.setName(task.getName());
        taskToProcess.setComplete(task.isComplete());

        Task updateTask = taskService.update(taskToProcess,id);

        TaskDto taskDto = new TaskDto();
        taskDto.setId(updateTask.getId());
        taskDto.setName(updateTask.getName());
        taskDto.setComplete(updateTask.isComplete());

        return taskDto;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id){
        taskService.delete(id);
    }
}
