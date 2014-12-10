package org.poul.modern;

import org.poul.modern.entities.Task;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TasksManager {
    public Collection<Task> getAll() {
        return em
            .createNamedQuery("Task.findAll")
            .getResultList();
    }

    public Task getByID(Integer id) {
        return (Task) em
            .createNamedQuery("Task.findByIdTask")
            .setParameter("idTask", id)
            .getSingleResult();
    }

    @PersistenceContext EntityManager em;
}
