package com.webservice.springwebservice.controller;

import com.webservice.springwebservice.domain.Project;
import com.webservice.springwebservice.services.MapValidationErrorService;
import com.webservice.springwebservice.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
   @Autowired
   private ProjectService projectService;

   @Autowired
   private MapValidationErrorService mapValidationErrorService;

   @GetMapping(path = "/test")
   private String testAPI(){
      return "hello world";
   }

   @PostMapping("")
   public ResponseEntity<?> createNewProject (@Valid @RequestBody Project project, BindingResult result){

      ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationErrorService(result) ;
      if(errorMap!=null){
         return errorMap;
      }

      Project project1 = projectService.saveOrUpdateProject(project);
      return new ResponseEntity<>(project1, HttpStatus.CREATED);
   }
   @GetMapping("/all")
   public ResponseEntity<?> getAllProject(){
      return new ResponseEntity<>(projectService.getAllProject(),HttpStatus.OK) ;
   }
}
