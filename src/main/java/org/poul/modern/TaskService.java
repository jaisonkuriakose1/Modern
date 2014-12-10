package org.poul.modern;

import org.poul.modern.entities.Task;
import java.util.Collection;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/todos") @Produces("application/json") @RequestScoped
public class TaskService {
    @GET @Path("/all")
    public Collection<Task> list() {
        return manager.getAll();
    }

    @GET @Path("/show/{id}")
    public Task detail(@PathParam("id") Integer id) {
        return manager.getByID(id);
    }

    @Inject private TasksManager manager;
}
