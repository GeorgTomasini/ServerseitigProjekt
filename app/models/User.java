package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Georg on 18.05.2017
 */
@Entity
public class User extends Model {
    @Id
    @Column(name="user_id")
    private Long id;

    private String email;
    private String passoword;
    private String role;
    private String firstname;
    private String lastname;

    public static Finder<String, User> find = new Finder<String, User>(User.class);

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return passoword;
    }

    public void setPassword(String passoword)
    {
        this.passoword = passoword;
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

    public User(String email, String passoword, String role, String firstname, String lastname)
    {
        this.email = email;
        this.passoword = passoword;
        this.role = role;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User()
    {
    }
}
