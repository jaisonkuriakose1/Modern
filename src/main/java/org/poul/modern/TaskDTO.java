package org.poul.modern;

import org.poul.modern.entities.Task;

public class TaskDTO {
    private String title;
    private String body;
    
    public TaskDTO() {
    }
    
    public TaskDTO(Task t) {
        title = t.getTitle();
        body = t.getBody();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
