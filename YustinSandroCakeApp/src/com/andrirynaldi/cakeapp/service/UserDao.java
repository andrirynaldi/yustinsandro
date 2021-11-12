/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.andrirynaldi.cakeapp.service;

import com.andrirynaldi.cakeapp.entity.User;
import com.andrirynaldi.cakeapp.error.CakeAppException;
import java.util.List;

/**
 *
 * @author andri
 */
public interface UserDao {
    public void insertUser(User user)throws CakeAppException;
    public void updateUser(User user)throws CakeAppException;
    public void deleteUser(Integer id)throws CakeAppException;
    public User getById(Integer id)throws CakeAppException;
    public User getByEmail(String email)throws CakeAppException;
    public List<User> getAll()throws CakeAppException;
}
