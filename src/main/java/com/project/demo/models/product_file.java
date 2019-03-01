package com.project.demo.models;

import javax.persistence.*;

@Entity
@Table(name="product_file")
public class product_file {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Integer id;
    @Column(name="file_name")
    private String fileName;
    @ManyToOne
    @JoinColumn(name="product_id")
    private product products;

    public product getProducts() {
        return products;
    }

    public void setProducts(product products) {
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getModifiledFileName() {
        return modifiledFileName;
    }

    public void setModifiledFileName(String modifiledFileName) {
        this.modifiledFileName = modifiledFileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    @Column(name="modifiled_file_name")
    private String modifiledFileName;
    @Column(name="file_extension")
    private String fileExtension;


}
