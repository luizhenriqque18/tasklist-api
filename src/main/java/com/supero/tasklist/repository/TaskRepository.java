package com.supero.tasklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supero.tasklist.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
