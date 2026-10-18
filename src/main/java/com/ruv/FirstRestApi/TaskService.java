package com.ruv.FirstRestApi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskService extends JpaRepository<Task,Long> {
    List<Task> findByStatus(String status);
}
