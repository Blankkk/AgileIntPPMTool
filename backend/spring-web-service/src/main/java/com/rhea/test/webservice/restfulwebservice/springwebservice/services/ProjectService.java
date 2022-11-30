package com.rhea.test.webservice.restfulwebservice.springwebservice.services;

import com.rhea.test.webservice.restfulwebservice.springwebservice.domain.Project;
import com.rhea.test.webservice.restfulwebservice.springwebservice.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject (Project p){
        return projectRepository.save(p);
    }

}
