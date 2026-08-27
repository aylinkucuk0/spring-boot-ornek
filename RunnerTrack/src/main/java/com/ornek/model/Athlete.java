package com.ornek.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "athletes")
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;

    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL)
    private List<RunRecord> runRecords;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public List<RunRecord> getRunRecords() { return runRecords; }
    public void setRunRecords(List<RunRecord> runRecords) { this.runRecords = runRecords; }
}
