/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andrirynaldi.cakeapp.model;


import com.andrirynaldi.cakeapp.database.CakeAppDatabase;
import com.andrirynaldi.cakeapp.entity.User;
import com.andrirynaldi.cakeapp.error.CakeAppException;
import com.andrirynaldi.cakeapp.event.RegisterListener;
import com.andrirynaldi.cakeapp.main.CakeApp;
import com.andrirynaldi.cakeapp.service.UserDao;
import java.sql.SQLException;

/**
 *
 * @author andri
 */
public class RegisterModel {
    private Integer id_user;
    private String fullname,email,password,role,created_at;
    private RegisterListener listener;

    public void setListner(RegisterListener listener) {
        this.listener = listener;
    }

    public RegisterListener getListner() {
        return listener;
    }
    
    

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
        fireOnChange();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
        fireOnChange();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        fireOnChange();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
        fireOnChange();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        fireOnChange();
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
        fireOnChange();
    }

    protected void fireOnChange(){
         if(listener!=null){
             listener.onChange(this);
         }
    }
    
    public void signUp() throws SQLException, CakeAppException{
        UserDao dao=CakeAppDatabase.getUserDao();
        User user=new User();
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        user.setCreated_at(created_at);
        dao.insertUser(user);
    }
    
    public void resetForm(){
        setId_user(0);
        setFullname("");
        setEmail("");
        setPassword("");
        setRole("");
        setCreated_at("");
    }
}
