package models;

import com.avaje.ebean.Model;

import javax.persistence.*;

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
    
    @ManyToOne
    private User user;
    
    
    public User getUser()
    {
        return user;
    }
    
    public void setUser(User user)
    {
        this.user = user;
    }
    
    public static Finder<String, Project> find = new Finder<String, Project>(Project.class);

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
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

    public Project( String name, String description)
    {

        this.name = name;
        this.description = description;
    }

    public Project()
    {

    }
}
