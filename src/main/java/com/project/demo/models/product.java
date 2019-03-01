package com.project.demo.models;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="product")
public class product  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private  Integer id;
    @Column(name="name")
    private String name;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }





    public com.project.demo.models.catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(com.project.demo.models.catalog catalog) {
        this.catalog = catalog;
    }

    @Column(name="price")
    private Double price;

    @Column(name="discount")
    private Float discount;
    @Column(name="create_date",nullable = false)
    private Timestamp create_date;


    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }

    public List<String> getRemoveImages() {
        return removeImages;
    }

    public void setRemoveImages(List<String> removeImages) {
        this.removeImages = removeImages;
    }

    @Transient
    private List<MultipartFile> files=new ArrayList<>();
    @Transient
    private List<String> removeImages=new ArrayList<String>();
    @OneToMany(mappedBy = "products",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<product_file> product;

    public Collection<detail> getDetails() {
        return details;
    }

    public void setDetails(Collection<detail> details) {
        this.details = details;
    }

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private Collection<detail> details;

    public Collection<product_file> getProduct() {
        return product;
    }

    public void setProduct(Collection<product_file> product) {
        this.product = product;
    }

    public com.project.demo.models.promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(com.project.demo.models.promotion promotion) {
        this.promotion = promotion;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_promotion")
    private promotion promotion;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_catalog")
    private catalog catalog ;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_producer")
    private producer producer;

    public com.project.demo.models.producer getProducer() {
        return producer;
    }

    public void setProducer(com.project.demo.models.producer producer) {
        this.producer = producer;
    }
   /* public Collection<detail> getDetails() {
        return details;
    }

    public void setDetails(Collection<detail> details) {
        this.details = details;
    }

    @OneToMany(mappedBy = "detail")
    private Collection<detail> details;*/











}
