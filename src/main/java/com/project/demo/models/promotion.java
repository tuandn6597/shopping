package com.project.demo.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "promotion")
public class promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    public promotion() {
    }

    @Column(name = "name_free")
    private String NameFree;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameFree() {
        return NameFree;
    }

    public void setNameFree(String nameFree) {
        NameFree = nameFree;
    }

    @Column(name = "date_start")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date DateStart;
    @OneToMany(mappedBy = "promotion",fetch = FetchType.LAZY)//,cascade = CascadeType.ALL)
    private Collection<product> products;

    public Collection<product> getProducts() {
        return products;
    }

    public void setProducts(Collection<product> products) {
        this.products = products;
    }

    @Column(name = "date_end")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date DateEnd;

    public Date getDateStart() {
        return DateStart;
    }

    public void setDateStart(Date dateStart) {
        DateStart = dateStart;
    }

    public Date getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        DateEnd = dateEnd;
    }
//    @OneToMany(mappedBy = "promotion",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private Collection<product> products;
//
//    public Collection<product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Collection<product> products) {
//        this.products = products;
//    }
}



