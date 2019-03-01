package com.project.demo.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="producer")
public class producer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false)
    private  Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_producer() {
        return name_producer;
    }

    public void setName_producer(String name_producer) {
        this.name_producer = name_producer;
    }



    @Column(name="name_producer")
    private String name_producer;
   @OneToMany(mappedBy = "producer",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<product> products;

    public Collection<product> getProducts() {
        return products;
    }

    public void setProducts(Collection<product> products) {
        this.products = products;
    }
}
