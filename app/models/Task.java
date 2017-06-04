package models;

import com.avaje.ebean.Model;
import com.avaje.ebean.config.JsonConfig;

import javax.persistence.*;

/**
 * Created by Georg on 18.05.2017.
 */
@Entity
public class Task extends Model
{
    @Id

    @Column(name="task_id")
    private long id;

    private String title;
    private JsonConfig.DateTime duration;
    private String description;
    
    @ManyToOne
    private Project project;
    
    public Project getProject()
    {
        return project;
    }
    
    public void setProject(Project project)
    {
        this.project = project;
    }
    
    public static Finder<String, Task> find = new Finder<String, Task>(Task.class);

    public Task(String title, JsonConfig.DateTime duration, String description)
    {
        this.title = title;
        this.duration = duration;
        this.description = description;
    }

    public Task()
    {
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public JsonConfig.DateTime getDuration()
    {
        return duration;
    }

    public void setDuration(JsonConfig.DateTime duration)
    {
        this.duration = duration;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
