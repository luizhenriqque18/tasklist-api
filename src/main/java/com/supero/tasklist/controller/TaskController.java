package com.supero.tasklist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.supero.tasklist.domain.Task;
import com.supero.tasklist.dto.Form.TaskFormDTO;
import com.supero.tasklist.service.TaskService;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "*")
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	
	@GetMapping
	@ResponseStatus( code = HttpStatus.OK)
	public Iterable<Task> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	@ResponseStatus( code = HttpStatus.CREATED )
	public Task create(@RequestBody TaskFormDTO dto) {
		return service.save(dto.convert());
	}
	
	@PutMapping
	public Task update(@RequestParam Long idTask,
					   @RequestBody TaskFormDTO dto)
	{
			Task task = service.findById(idTask);
		
			return service.save(dto.convert(task));
	}
	
	@PutMapping(path = "changeStatus")
	public Task changeStatus(@RequestParam Long idTask) 
	{
		Task task = service.findById(idTask); 

		task.setStatus(!task.isStatus());
			
		return service.save(task);
	}
	
	
	@DeleteMapping("/{idTask}")
	public boolean delete(@PathVariable("idTask") Long idTask) {
		
		Task task = service.findById(idTask); 
				
		return service.delete(task);
	}
}
