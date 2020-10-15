package com.supero.tasklist.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supero.tasklist.domain.Task;
import com.supero.tasklist.repository.TaskRepository;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskRepository repository;
	
	
	@GetMapping
	public Iterable<Task> findAll() {
		return repository.findAll();
	}
	
	@PostMapping
	public Task create(@RequestBody Task task) {
		return repository.save(task);
	}
	
	@PutMapping
	public Task update(@RequestParam Long idTask,
					   @RequestBody Task task) 
	{
		Optional<Task> t = repository.findById(idTask); 
		
		if(t.isPresent()) {
			t.get().setTitle(task.getTitle());
			return repository.save(t.get());
		}
		return null;
	}
	
	@DeleteMapping("/{idTask}")
	public boolean delete(@PathVariable("idTask") Long idTask) {
		
		Optional<Task> t = repository.findById(idTask); 
		
		if(t.isPresent()) {
			repository.delete(t.get());
			return true;
		}
		return false;
	}
}
