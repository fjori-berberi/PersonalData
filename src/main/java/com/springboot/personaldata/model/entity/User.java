package com.springboot.personaldata.model.entity;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;



    @Column(name="name") private String name;
    @Column(name="surname") private String surname;
    @Column(name="deleted")private Boolean deleted;

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getSurname() {return surname;}

    public void setSurname(String surname) {this.surname = surname;}

    public Boolean getDeleted() {return deleted;}

    public void setDeleted(Boolean deleted) {this.deleted = deleted;}

    public Integer getId() {return id;}
    
    public void setId(Integer id) { this.id = id;}

}
