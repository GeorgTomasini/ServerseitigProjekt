package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Georg on 18.05.2017.
 */
@Entity
public class Project extends Model
{
    @Id
    @Column(name="project_id")
    private long id;

    private String name;
    private String description;
    
    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE)
    private List<Task> tasks;
    
    
    @ManyToOne
    private Customer customer;
    
    @Transient
    private String tmpcustomer;
    
    public Long projectDuration()
    {
        Long duration = 0L;
        for(Task task: tasks)
        {
            duration += task.getDuration();
        }
        return duration;
    }
    
    public List<Task> getTasks()
    {
        return tasks;
    }
    
    public void setTasks(List<Task> tasks)
    {
        this.tasks = tasks;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }
    
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    public String getTmpcustomer()
    {
        return tmpcustomer;
    }
    
    public void setTmpcustomer(String tmpcustomer)
    {
        this.tmpcustomer = tmpcustomer;
    }
    
    public static Finder<String, Project> find = new Finder<String, Project>(Project.class);

    public long getId()
    {
        return id;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }


    public Project()
    {

    }
}
