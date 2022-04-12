package cz.upce.nnpia.be.repository;

import cz.upce.nnpia.be.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {

}
