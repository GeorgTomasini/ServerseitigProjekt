package controllers;

import com.google.inject.Inject;
import models.Customer;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.List;

/**
 * Created by Georg on 09.06.17.
 */
public class CustomerController extends Controller {
    
    @Inject
    public FormFactory formFactory;
    
    
    public Result list() {
        List<Customer> customerList = Customer.find.all();
        
        return ok(views.html.customerList.render(customerList));
    }
    
    public Result show(String id) {
        
        Customer customer = Customer.find.byId(id);
        
        return ok(views.html.customer.render(customer));
    }
    
    public Result create() {
        Form<Customer> customerForm = formFactory.form(Customer.class);
        Customer customer = customerForm.bindFromRequest().get();
        customer.save();
        return  redirect(routes.CustomerController.list());
    }
    
    public Result delete(String id) {
        
        Customer customer = Customer.find.byId(id);
        
        customer.delete();
        
        return redirect(routes.CustomerController.list());
        
    }
}
