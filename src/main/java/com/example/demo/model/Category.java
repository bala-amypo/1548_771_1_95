package com.example.demo.model;
@Entity
public class Category {
    @Id
    private Long id;
    @Column(unique=true)
    private String name;
    private String type;

    public Category(){

    }

    public Category(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
