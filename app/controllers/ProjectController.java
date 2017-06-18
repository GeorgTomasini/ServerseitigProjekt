package controllers;

import com.google.inject.Inject;
import models.Customer;
import models.Project;
import models.Task;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by Georg on 09.05.17.
 */
public class ProjectController extends Controller
{

        @Inject
        public FormFactory formFactory;
    
    public Result list()
    {
        
        List<Project> projectList = Project.find.all();
        
        
        return ok(views.html.projectList.render(projectList));
        
    }

    public Result create()
    {
    
        Form<Project> projectForm = formFactory.form(Project.class);
        Project project = projectForm.bindFromRequest().get();
        project.setCustomer(Customer.find.byId(project.getTmpcustomer()));
        
        project.save();
        return redirect(routes.ProjectController.list());
    }
    
    public Result modify(String id)
    {
        Form<Project> projectForm = formFactory.form(Project.class);
    
    
        Project project = Project.find.byId(id);
    
        Project projectTemp = projectForm.bindFromRequest().get();
    
        if (project != null && projectTemp != null && project.getId() == projectTemp.getId())
        {
            if(!project.getDescription().equals(projectTemp.getDescription()))
            {
                project.setDescription(projectTemp.getDescription());
            }
            else if(!project.getName().equals(projectTemp.getName()))
            {
                project.setName(projectTemp.getName());
            }
            else if(!project.getCustomer().equals(projectTemp.getCustomer()))
            {
                project.setCustomer(projectTemp.getCustomer());
            }
        }
    
    
        return ok();
    }
    
    public Result show(String id)
    {
        Project project = Project.find.byId(id);
                
        return ok(views.html.project.render(project));
    }
  
    public Result delete(String id)
    {
        Project project = Project.find.byId(id);
        project.delete();
    
        return redirect(routes.ProjectController.list());
    }
    
    public Result search(String name){
        
        List<Project> projectList = Project.find.where().contains("name", name).findList();

        return ok(views.html.projectList.render(projectList));
    }
    
    
}
