package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name="toys")
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length =50)
    private String name;

    @ManyToOne
    @JoinColumn(name="dog_id")
    private Dog dog;

    public Toy() {

    }

    public Toy(String name) {

    }

    public Toy(String name, Dog dog) {

        this.name = name;
        this.dog = dog;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }


}

