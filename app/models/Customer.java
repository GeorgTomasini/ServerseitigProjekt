package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Georg on 18.06.2017.
 */
@Entity
public class Customer extends Model
{
    @Id
    @Column(name = "customer_id")
    private Long id;
    
    private String name;
        
    @OneToMany(cascade = CascadeType.REMOVE)
    List<Project> projects;
    
    public static Finder<String,Customer> find = new Finder<String, Customer>(Customer.class);
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public List<Project> getProjects()
    {
        return projects;
    }
    
    public void setProjects(List<Project> projects)
    {
        this.projects = projects;
    }
}
