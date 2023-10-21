package com.jwt.implementation.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(name = "role_name")
    private String role;

   /* @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private Set<User> users;*/

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    public Role() {}


    public String getRoleName() {return role;}
    public void setRoleName(String roleName) {this.role = roleName;}
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
