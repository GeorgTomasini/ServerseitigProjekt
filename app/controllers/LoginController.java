package controllers;

import com.google.inject.Inject;
import models.User;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by martinschipflinger on 09.05.17.
 */
public class LoginController extends Controller {

    @Inject
    public FormFactory formFactory;

    public Result login(String email, String password){

        List<User> usersList = User.find.all();

        for(User u : usersList)
        {

            if(u.getEmail().equals(email) && u.getPassword().equals(password))
            {
                return ok();
            }
        }


        return ok();
    }

    public Result addProduct(){

        return ok();
    }

    public Result addTag(){

        return ok();
    }
}
