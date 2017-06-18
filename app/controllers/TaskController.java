package controllers;

import com.google.inject.Inject;
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
public class TaskController extends Controller {
    
    
    @Inject
    public FormFactory formFactory;
    
    public Result list()
    {
        
        List<Task> taskList = Task.find.all();
        
        
        return ok(views.html.taskList.render(taskList));
        
    }
    
    public Result create()
    {
        
        Form<Task> taskForm = formFactory.form(Task.class);
        
        Task task = taskForm.bindFromRequest().get();
        task.setProject(Project.find.byId(task.getTmpproject()));
        task.save();
        return redirect(routes.TaskController.list());
    }
    
    public Result modify(String id)
    {
        Form<Task> taskForm = formFactory.form(Task.class);
        
        
        Task task = Task.find.byId(id);
        
        Task taskTemp = taskForm.bindFromRequest().get();
        
        if (task != null && taskTemp != null && task.getId() == taskTemp.getId())
        {
            if(!task.getDescription().equals(taskTemp.getDescription()))
            {
                task.setDescription(taskTemp.getDescription());
            }
            else if(!task.getDuration().equals(taskTemp.getDuration()))
            {
                task.setDuration(taskTemp.getDuration());
            }
            else if(!task.getProject().equals(taskTemp.getProject()))
            {
                task.setProject(taskTemp.getProject());
            }
            else if(!task.getTitle().equals(taskTemp.getTitle()))
            {
                task.setTitle(taskTemp.getTitle());
            }
        }
        
        
        return ok();
    }
    
    public Result show(String id)
    {
        Task task = Task.find.byId(id);
        
        
        return ok(views.html.task.render(task));
    }
    
    public Result delete(String id)
    {
        
        Task task = Task.find.byId(id);
        task.delete();
        
        return redirect(routes.TaskController.list());
    }
}
