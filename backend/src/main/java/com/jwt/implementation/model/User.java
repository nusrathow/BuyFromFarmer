package com.jwt.implementation.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
    @Table(name= "User")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String userName;
        private String password;
        private String email;

        //user many roles
        /*@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
        @JoinTable(name = "User_Role",
                joinColumns = {
                        @JoinColumn(name = "user_id",referencedColumnName = "id")
                },
                inverseJoinColumns = {
                        @JoinColumn(name = "role_id", referencedColumnName = "id")
                })
        private Set<Role> roles;*/

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Role> roles = new HashSet<>();

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getUserName() {
            return userName;
        }
        public void setUserName(String userName) {
            this.userName = userName;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        /*public Set<Role> getRole() {
            return roles;
        }

        public void setRole(Role role) {
            this.roles.add(role);
        }*/

    public Set<Role> getRole() {
        return roles;
    }

    public void setRole(Set<Role> userRoles) {
        this.roles = userRoles;

        for (Role r : userRoles) {
            r.setUser(this);
        }
    }



    }