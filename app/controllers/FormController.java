package controllers;

import models.*;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Georg on 12.06.2017.
 */
public class FormController extends Controller
{
    @Inject
    public FormFactory formFactory;
    
    public Result addCustomer(){
        Form<Customer> customerForm = formFactory.form(Customer.class);
        return ok(views.html.addCustomer.render(customerForm));
    }
    
    public Result addProject(){
        
        Form<Project> projectForm = formFactory.form(Project.class);
        List<Customer> customerList = Customer.find.all();
        return ok(views.html.addProject.render(projectForm, customerList));
        
    }
    
    public Result addTask(){
        
        Form<Task> taskForm = formFactory.form(Task.class);
        List<Project> projectList = Project.find.all();
        List<Employee> employeeList = Employee.find.all();
        return ok(views.html.addTask.render(taskForm, projectList, employeeList));
    }
    
    public Result addEmployee(){
        Form<Employee> employeeForm = formFactory.form(Employee.class);
        return ok(views.html.addEmployee.render(employeeForm));
    }
}
