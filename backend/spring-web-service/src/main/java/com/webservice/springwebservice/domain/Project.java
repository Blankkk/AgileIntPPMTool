package com.webservice.springwebservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Project Name is required")
    private String projectName;

    @NotEmpty(message = "Project Identifier is required")
    @Size(min = 4, max = 5, message = "Please use 4 or 5 characters")
    @Column(updatable = false , unique = true)
    private String projectIdentifier;

    @jakarta.validation.constraints.NotEmpty(message = "Project Description is required")
    private String description;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date endDate;

    public Project() {
    }
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date createAt ;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updateAt;

    @PrePersist
    protected void onCreate(){
        this.createAt = new Date();
    }
    @PreUpdate
    protected void onUpdate (){
        this.updateAt = new Date();
    }
}
