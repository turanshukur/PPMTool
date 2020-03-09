package com.turanshukur.ppmtool.web;

import com.turanshukur.ppmtool.domain.Project;
import com.turanshukur.ppmtool.services.MapValidationErrorService;
import com.turanshukur.ppmtool.services.ProjcetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjcetService projcetService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){

        ResponseEntity<?> errorMap =  mapValidationErrorService.MapValidationService(result);
        if (errorMap!=null){
            return errorMap;
        }
            Project project1 = projcetService.saveOrUpdate(project);
            return new ResponseEntity<Project>(project1, HttpStatus.OK);

    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> findByProjectId(@PathVariable String projectId){
        Project project = projcetService.findByProjectIdentifier(projectId);
            return new ResponseEntity<Project>(project, HttpStatus.OK);

        }

    @GetMapping("/all")
    public Iterable<Project> findAllProject(){
            return projcetService.findAllProjects();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProjectById(@PathVariable String projectId){
        projcetService.deleteProjectById(projectId);
        return new ResponseEntity<String>("Project with ID: '"+ projectId +"' was deleted", HttpStatus.OK);
    }
}
