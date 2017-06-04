package controllers;

import com.google.inject.Inject;
import models.User;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class UserController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    @Inject
    public FormFactory formFactory;
    public Result index() {
        return ok();

    }
    
    public Result createUser()
    {
        
        
        Form<User> userForm = formFactory.form(User.class);
        
        User user = userForm.bindFromRequest().get();
        user.save();
        return redirect("");
    }
    
    public Result modifyUser(String id)
    {
        Form<User> userForm = formFactory.form(User.class);
        
        
        User user = User.find.byId(id);
        
        User userTemp = userForm.bindFromRequest().get();
        
        if (user != null && userTemp != null && user.getId().equals(userTemp.getId()))
        {
            if(!user.getEmail().equals(userTemp.getEmail()))
            {
                user.setEmail(userTemp.getEmail());
            }
            else if(!user.getPassword().equals(userTemp.getPassword()))
            {
                user.setPassword(userTemp.getPassword());
            }
            else if(!user.getRole().equals(userTemp.getRole()))
            {
                user.setRole(userTemp.getRole());
            }
            else if(!user.getFirstname().equals(userTemp.getFirstname()))
            {
                user.setFirstname(userTemp.getFirstname());
            }
            else if(!user.getLastname().equals(userTemp.getLastname()))
            {
                user.setLastname(userTemp.getLastname());
            }
        }
        
        
        return ok();
    }
    
    public Result deleteUser(String id)
    {
        User user = User.find.byId(id);
        
        user.delete();
        return redirect("");
    }
    
    public Result showUser(String id)
    {
        User user = User.find.byId(id);
        return ok("");
        
    }
    
    public Result listUsers()
    {
        List<User> userList = User.find.all();
        
        return ok("");
    }

}
