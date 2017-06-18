package controllers;

import com.google.inject.Inject;
import models.Employee;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by Georg on 18.06.2017.
 */
public class EmployeeController extends Controller
{
    
    @Inject
    public FormFactory formFactory;
    
    public Result list() {
        List<Employee> employeeList = Employee.find.all();
        return ok(views.html.employeeList.render(employeeList));
    }
    
    public Result show(String id) {
        Employee employee = Employee.find.byId(id);
        return ok(views.html.employee.render(employee));
    }
    
    public Result create() {
        Form<Employee> employeeForm = formFactory.form(Employee.class);
        Employee employee = employeeForm.bindFromRequest().get();
        employee.save();
        return  redirect(routes.EmployeeController.list());
    }
    
    public Result delete(String id) {
        
        Employee employee = Employee.find.byId(id);
        employee.delete();
        return redirect(routes.EmployeeController.list());
    }
    
}
