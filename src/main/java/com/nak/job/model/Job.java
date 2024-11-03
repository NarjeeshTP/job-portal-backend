package com.nak.job.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobs") // Specifies the MongoDB collection name
public class Job {

    @Id // Marks this field as the primary key in MongoDB
    private String id;
    private String title;
    private String description;
    private String location;
    private String company;
    private String employmentType; // e.g., Full-Time, Part-Time, Contract
    private double salary;

    // Default constructor
    public Job() {
    }

    // Parameterized constructor
    public Job(String title, String description, String location, String company, String employmentType, double salary) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.company = company;
        this.employmentType = employmentType;
        this.salary = salary;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString method for easy logging
    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", company='" + company + '\'' +
                ", employmentType='" + employmentType + '\'' +
                ", salary=" + salary +
                '}';
    }
}
