package com.eduardafbz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardafbz.exceptions.ResourceNotFoundException;
import com.eduardafbz.model.Task;
import com.eduardafbz.repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    public TaskRepository taskRepository;

    public Task add(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task update(Long id, String novaDescricao) {
        Task task = taskRepository.findById(id).orElseThrow();

        task.setDescricao(novaDescricao);
        return taskRepository.save(task);

    }

    public void delete(Long id) {
        try {
            taskRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
    
}