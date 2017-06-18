package models;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by Georg on 18.05.2017
 */
@Entity
public class Employee extends Model {
    @Id
    @Column(name="employee_id")
    private Long id;

    private String role;
    private String firstname;
    private String lastname;

    public static Finder<String, Employee> find = new Finder<String, Employee>(Employee.class);

    public Long getId()
    {
        return id;
    }


    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }



    public Employee()
    {
    }
}
