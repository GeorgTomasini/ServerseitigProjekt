package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by martinschipflinger on 09.05.17.
 */
public class LoginController extends Controller {


    public Result login(){

        List<User> usersList = User.find.all();

        for(User u : usersList)
        {
            if(u.getEmail().equals(email) && u.getPassoword().equals(password))
            {
                return ok(view.reder.);
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
