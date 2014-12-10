package org.poul.modern;

import java.util.Collection;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/todos") @Produces("application/json") @RequestScoped
public class TaskService {
    @GET @Path("/all")
    public Collection<TaskDTO> list() {
        return taskManager.getAll();
    }

    @POST @Path("/new")
    public Response add(TaskDTO t){
        TaskDTO task = taskManager.add(t.getTitle(), t.getBody());
        return Response
            .status(201)
            .entity(task)
            .build();
    }

    @GET @Path("/show/{id}")
    public Response detail(@PathParam("id") Integer id) {
        TaskDTO task = taskManager.getByID(id);
        
        if (task == null) {
            return Response
                .status(404)
                .build();
        } else {
            return Response
                .ok(task)
                .build();
        }
    }

    @Inject private TasksManager taskManager;
}
