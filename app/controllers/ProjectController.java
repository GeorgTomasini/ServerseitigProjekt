package controllers;

import com.google.inject.Inject;
import models.Project;
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
    
    public Result listProjects()
    {
        
        List<Project> projectList = Project.find.all();
        
        
        return ok();
        
    }

    public Result createProject()
    {
    
        Form<Project> projectForm = formFactory.form(Project.class);
    
        Project project = projectForm.bindFromRequest().get();
        project.save();
        return ok();
    }
    
    public Result modifyProject(String id)
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
            else if(!project.getUser().equals(projectTemp.getUser()))
            {
                project.setUser(projectTemp.getUser());
            }
        }
    
    
        return ok();
    }
    
    public Result showProject(String id)
    {
        Project project = Project.find.byId(id);
        
        
        return ok();
    }
  
    public Result deleteProject(String id)
    {
        
        Project project = Project.find.byId(id);
        project.delete();
    
        return ok();
    }
    
    
    
    
}
