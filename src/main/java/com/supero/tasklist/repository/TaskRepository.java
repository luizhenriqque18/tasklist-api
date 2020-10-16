package com.supero.tasklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supero.tasklist.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
