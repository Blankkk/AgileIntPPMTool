package com.rhea.test.webservice.restfulwebservice.springwebservice.controller;

import com.rhea.test.webservice.restfulwebservice.springwebservice.domain.Project;
import com.rhea.test.webservice.restfulwebservice.springwebservice.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
   @Autowired
   private ProjectService projectService;

   @GetMapping(path = "/test")
   private String testAPI(){
      return "hello world";
   }

   @PostMapping("")
   public ResponseEntity<?> createNewProject (@Valid @RequestBody Project project, BindingResult result){

      if(result.hasErrors()){

         Map<String,String> errorMap = new HashMap<>();
         result.getFieldErrors().forEach(x ->
            errorMap.put(x.getField() , x.getDefaultMessage())
         );

         return new ResponseEntity<>(errorMap , HttpStatus.BAD_REQUEST);
      }

      Project project1 = projectService.saveOrUpdateProject(project);
      return new ResponseEntity<>(project1, HttpStatus.CREATED);

   }
}
