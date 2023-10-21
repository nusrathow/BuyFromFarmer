package com.jwt.implementation.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "farmer")
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @Column(name = "available_quantity")
    private Long availableQuantity;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "Farmer_Product",
            joinColumns = {
                    @JoinColumn(name = "farmer_id",referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "product_id", referencedColumnName = "id")
            })
    private Set<Product> products;


    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public Orders getOrder() {return orders;}

    public void setOrder(Orders orders) {this.orders = orders;}
    public Long getAvailableQuantity() {return availableQuantity;}

    public void setAvailableQuantity(Long availableQuantity) {this.availableQuantity = availableQuantity;}

    public Set<Product> getProducts() {return products;}

    public void setProducts(Set<Product> products) {this.products = products;}
}