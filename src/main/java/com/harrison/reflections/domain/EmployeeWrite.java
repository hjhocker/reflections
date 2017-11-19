package com.harrison.reflections.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employee")
public class EmployeeWrite implements Serializable {

    private static final long serialVersionUID = -4172063317499569232L;

    @Id
    @Column(name="EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    
    @Column(name="FIRST_NAME")
    private String firstName;
    
    @Column(name="LAST_NAME")
    private String lastName;
    
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="manager_id")
    private EmployeeWrite manager;

    @JsonIgnoreProperties({"manager"})
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private Set<EmployeeWrite> subordinates = new HashSet<EmployeeWrite>();

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmployeeWrite getManager() {
        return manager;
    }

    public void setManager(EmployeeWrite manager) {
        this.manager = manager;
    }

    public Set<EmployeeWrite> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<EmployeeWrite> subordinates) {
        this.subordinates = subordinates;
    }

    
}
