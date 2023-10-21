package com.jwt.implementation.model;

import javax.persistence.*;

@Entity
@Table(name = "checkOut")
public class CheckOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;*/

    @Column(name = "total")
    private Long total;

   /* @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;*/

    @Column(name = "address")
    private String address;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }*/

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    /*public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
