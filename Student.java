/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exprine.controller;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author rant
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Student.findAll",
            query = "Select e From Student e"),
    @NamedQuery(name = "Student.findById",
            query = "Select e From Student e Where e.id= :id"),
    @NamedQuery(name = "Student.update",
            query = "Update Student e Set e.name = :name,e.major= :major,e.grade= :grade  Where e.id = :id"),
     @NamedQuery(name = "Student.delete",
            query = "DELETE FROM Student e where e.id = :id")
    
})
public class Student  {
    @Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String major;
    private Double grade;

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
    
    
}
