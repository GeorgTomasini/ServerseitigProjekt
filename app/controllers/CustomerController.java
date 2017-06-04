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
        return ok();
    }

    public Result show(Long id){
        return ok();
    }

    public Result create(){
        return ok();
    }
    
    public Result delteCustomer(){return ok();}
    
    public Result modifyCustomer() {return ok();}
    

}
