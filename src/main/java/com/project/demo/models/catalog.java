package com.project.demo.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="catalog")
public class catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false)
    private  Integer  id_catalog;

    public Integer getId_catalog() {
        return id_catalog;
    }

    public void setId_catalog(Integer id_catalog) {
        this.id_catalog = id_catalog;
    }

    @Column(name="name_catalog")
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    @Column(name="sort_order")
    private Integer sort;
    @Column(name="parent_id")
    private Integer parent;
    @OneToMany(mappedBy = "catalog",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<product> products;
    public catalog(){

    }

    public Collection<product> getProducts() {
        return products;
    }

    public void setProducts(Collection<product> products) {
        this.products = products;
    }




}
