/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andrirynaldi.cakeapp.entity;

import java.util.Objects;

/**
 *
 * @author andri
 */
public class User {
    private Integer id_user;
    private String fullname, email,password,role;
    private String created_at;

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id_user);
        hash = 43 * hash + Objects.hashCode(this.fullname);
        hash = 43 * hash + Objects.hashCode(this.email);
        hash = 43 * hash + Objects.hashCode(this.password);
        hash = 43 * hash + Objects.hashCode(this.role);
        hash = 43 * hash + Objects.hashCode(this.created_at);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.fullname, other.fullname)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        if (!Objects.equals(this.created_at, other.created_at)) {
            return false;
        }
        if (!Objects.equals(this.id_user, other.id_user)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", fullname=" + fullname + ", email=" + email + ", password=" + password + ", role=" + role + ", created_at=" + created_at + '}';
    }

      
    
}
