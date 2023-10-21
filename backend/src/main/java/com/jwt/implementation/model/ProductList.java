package com.jwt.implementation.model;

import javax.persistence.*;

@Entity
@Table(name = "product_list")
public class ProductList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image",length = 64)
    private String image;

    @Transient
    public String getImagePath(){
        if(image == null) return null;

        return "/productList/"+id+"/"+image;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "measurement")
    private String measurement;

    public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getMeasurement() {return measurement;}

    public void setMeasurement(String measurement) {this.measurement = measurement;}

    public String getImage() {return image;}

    public void setImage(String image) {this.image = image;}
}
