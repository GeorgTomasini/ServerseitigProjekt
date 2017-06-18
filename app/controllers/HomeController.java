package controllers;

import models.Project;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;


public class HomeController extends Controller
{
    public Result index()
    {
        List<Project> projectList = Project.find.all();
        
        return ok(views.html.projectList.render(projectList));
    }
}
