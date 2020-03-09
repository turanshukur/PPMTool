package com.turanshukur.ppmtool.services;

import com.turanshukur.ppmtool.domain.Project;
import com.turanshukur.ppmtool.exceptions.ProjectIdException;
import com.turanshukur.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjcetService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project){
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException("PROJECT ID '"+ project.getProjectIdentifier().toUpperCase() + "' already exists");
        }

    }

    public Project findByProjectIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if (project == null){
            throw new ProjectIdException("PROJECT ID '"+ projectId.toUpperCase() + "' doesn`t exists");
        }
        return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();

    }

    public void deleteProjectById(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if (project==null){
            throw new ProjectIdException("Cannot delete Project with ID: '"+projectId.toUpperCase()+"' This Project doesn`t exists");
        }
        projectRepository.delete(project);
    }
}
