package com.supero.tasklist.dto.Form;

import com.supero.tasklist.domain.Task;

public class TaskFormDTO {

	private String title;
	
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Task convert() {
		return new Task(title, description);
	}

	public Task convert(Task t) {
		return new Task(t ,title, description);
	}
}
