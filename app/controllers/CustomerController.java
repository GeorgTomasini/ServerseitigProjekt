package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.List;

/**
 * Created by martinschipflinger on 09.05.17.
 */
public class CustomerController extends Controller {

    public Result list(){
    }

    public Result show(Long id){
        return ok();
    }

    public Result create(){
        return ok();
    }

}
