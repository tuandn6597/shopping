package com.project.demo.models;



import javax.persistence.*;

@Entity
@Table(name="detail")
public class detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private  Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber_product() {
        return number_product;
    }

    public void setNumber_product(Integer number_product) {
        this.number_product = number_product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public com.project.demo.models.transaction getTransaction() {
        return transactions;
    }

    public void setTransaction(com.project.demo.models.transaction transaction) {
        this.transactions = transaction;
    }

    public com.project.demo.models.product getProduct() {
        return product;
    }

    public void setProduct(com.project.demo.models.product product) {
        this.product = product;
    }

    @Column(name="number_product")
    private Integer number_product;
    @Column(name="status")
    private String status;
    @Column(name="amount")
    private Double amount;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_transaction")
    private transaction transactions;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_product")
    private product product;


}
