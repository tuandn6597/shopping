package com.project.demo.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name="transaction")
public class transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Integer id;
    @Column(name="amount")
    private Double amount;
    @Column(name="status")
    private String status;
    @Column(name="create_date")
    private Timestamp create_date;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_cus")
    private customer customer;
    @OneToMany(mappedBy = "transactions",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<detail> details;


    public Collection<detail> getDetails() {
        return details;
    }

    public void setDetails(Collection<detail> details) {
        this.details = details;
    }

    public com.project.demo.models.customer getCustomer() {
        return customer;
    }

    public void setCustomer(com.project.demo.models.customer customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {        this.message = message;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Column(name="message")
    private String message;
    @Column(name="payment")
    private String payment;
}
