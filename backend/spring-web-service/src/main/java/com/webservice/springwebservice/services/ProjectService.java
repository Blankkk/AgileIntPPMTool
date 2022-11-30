package com.webservice.springwebservice.services;

import com.webservice.exception.ProjectIdException;
import com.webservice.springwebservice.domain.Project;
import com.webservice.springwebservice.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject (Project p){
        try{
            p.setProjectIdentifier(p.getProjectIdentifier().toUpperCase());
            return projectRepository.save(p) ;
        }catch (Exception e){
            throw new ProjectIdException("Project ID " + p.getProjectIdentifier().toUpperCase(Locale.ROOT)+" already exist!");
        }
    }

    public List<?> getAllProject(){
        List<Project> projectList = new ArrayList<>();
        projectRepository.findAll().forEach(projectList::add);
        return  projectList;
    }

}
