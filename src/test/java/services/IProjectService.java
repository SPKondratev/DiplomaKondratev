package services;

import io.restassured.response.Response;
import models.Project;

public interface IProjectService {
    Response getGeneralProject(int id);
    Response getAllProjects(String endpoint);
    Project getProject(int id);
    void getProjects();
    Project addProject(Project project);
    Project updateProject(Project project);
    Response deleteProject(int id);
}
