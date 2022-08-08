package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "veterinary")
public class Vet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length=100)
    private String name;
    @ManyToMany(mappedBy = "veterinary")
    private List<Dog> dogs;

    public Vet() {
    }

    public Vet(String name, List<Dog> dogs) {
        this.name = name;
        this.dogs = dogs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }
}
