package org.poul.modern;

/*
 * Copyright (c) 2014, Stefano Sanfilippo
 * All rights reserved.
 *
 * BSD licensed. See LICENSE.txt for more information.
 */

import java.util.ArrayList;
import org.poul.modern.entities.Task;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class TasksManager {
    @PersistenceContext private EntityManager em;

    public Collection<TaskDTO> getAll() {
        Collection<Task> tasks = em
            .createNamedQuery("Task.findAll")
            .getResultList();
        
        Collection<TaskDTO> ts = new ArrayList<>();
        for (Task t: tasks) {
            ts.add(new TaskDTO(t));
        }
        return ts;
    }
    
    public TaskDTO add(String title, String body) {
        Task task = new Task(title, slugify(title));
        task.setBody(body);
        em.persist(task);
        return new TaskDTO(task);
    }

    public TaskDTO getByID(Integer id) {
        try {
            Task t = em
                .createNamedQuery("Task.findByIdTask", Task.class)
                .setParameter("idTask", id)
                .getSingleResult();
            return new TaskDTO(t);
        } catch (NoResultException e) {
            return null;
        }
    }

    private String slugify(String title) {
        return title.toLowerCase().replace(' ', '-');
    }
}
