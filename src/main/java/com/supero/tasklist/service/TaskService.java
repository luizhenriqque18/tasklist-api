package com.supero.tasklist.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.supero.tasklist.domain.Task;
import com.supero.tasklist.exception.TaskNotExist;
import com.supero.tasklist.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repository;
	
	
	public Task save(Task task) {
		return repository.save(task);		
	}


	public Iterable<Task> findAll() {
		return this.repository.findAll();
	}


	public Task findById(Long idTask) {
		Optional<Task> task;
		
		try {
			task = repository.findById(idTask);
			
			if(task.isEmpty()) throw new EmptyResultDataAccessException(0);
			
		}catch (EmptyResultDataAccessException e) {
			throw new TaskNotExist(String.format("Tarefa com id %d não existe!", idTask));
		}
		return task.get();
	}


	public boolean delete(Task task) {
		repository.delete(task);
		
		return true;
	}
}
