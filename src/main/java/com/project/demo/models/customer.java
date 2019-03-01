package com.project.demo.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name="customer")
public class customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public customer() {
    }
    @Column(name = "create_date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date CreateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Column(name="name")
    private String Name;

    @Column(name = "phone")
    private String Phone;

    public Collection<transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Collection<transaction> transactions) {
        this.transactions = transactions;
    }

    @Column(name = "address")
    private String Address;
    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<transaction>  transactions;

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

//    public String getCreateDate() {
//        return CreateDate;
//    }
//
//    public void setCreateDate(String createDate) {
//        CreateDate = createDate;
//    }


}