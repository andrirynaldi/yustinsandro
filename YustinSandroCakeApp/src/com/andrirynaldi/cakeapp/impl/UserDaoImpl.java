/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andrirynaldi.cakeapp.impl;

import com.andrirynaldi.cakeapp.entity.User;
import com.andrirynaldi.cakeapp.error.CakeAppException;
import java.sql.Connection;
import com.andrirynaldi.cakeapp.service.UserDao;
import java.sql.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andri
 */
public class UserDaoImpl implements UserDao{
    private Connection connection;
    private String addUser="insert into tbl_user(fullname,email,password,role,created_at) values(?,?,?,?,?)";
    private String updateUser="update tbl_user set fullname=?,email=?,password=?,role=?,created_at=? where id_user=?";
    private String delete="delete from tbl_user where id_user=?";
    private String findId="select * from tbl_user where id_user=?";
    private String findEmail="select * from tbl_user where email=?";
    private String selectAll="select * from tbl_user order by id_user desc";

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    

    @Override
    public void insertUser(User user) throws CakeAppException {
        PreparedStatement pst=null;
        try {
            connection.setAutoCommit(false);
            pst=connection.prepareStatement(addUser);
            pst.setString(1, user.getFullname());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getRole());
            pst.setString(5, user.getCreated_at());
            pst.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            throw new CakeAppException(ex.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(pst!=null){
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void updateUser(User user) throws CakeAppException {
         PreparedStatement pst=null;
        try {
            connection.setAutoCommit(false);
            pst=connection.prepareStatement(updateUser);
            pst.setString(1, user.getFullname());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getRole());
            pst.setString(5, user.getCreated_at());
            pst.setInt(6, user.getId_user());
            pst.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            throw new CakeAppException(ex.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(pst!=null){
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public User getById(Integer id) throws CakeAppException {
         PreparedStatement pst=null;
        try {
            connection.setAutoCommit(false);
            pst=connection.prepareStatement(findId);
            pst.setInt(1, id);
            ResultSet rs=pst.executeQuery();
             User user=null;
            if(rs.next()){
                user=new User();
                user.setId_user(rs.getInt("id_user"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setCreated_at(rs.getString("created_at"));
                
            }else{
                throw new CakeAppException("User dengan id "+id+" tidak ditemukan");
            }
            connection.commit();
            return user;
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            throw new CakeAppException(ex.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(pst!=null){
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public User getByEmail(String email) throws CakeAppException {
        PreparedStatement pst=null;
        try {
            connection.setAutoCommit(false);
            pst=connection.prepareStatement(findEmail);
            pst.setString(1, email);
            ResultSet rs=pst.executeQuery();
            User user=null;
            if(rs.next()){
                user=new User();
                user.setId_user(rs.getInt("id_user"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setCreated_at(rs.getString("created_at"));
            }else{
                throw new CakeAppException("User dengan email "+email+" tidak ditemukan");
            }
            connection.commit();
            return user;
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            throw new CakeAppException(ex.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(pst!=null){
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<User> getAll() throws CakeAppException {
         PreparedStatement pst=null;
         List<User> list= new ArrayList<User>();
        try {
            connection.setAutoCommit(false);
            pst=connection.prepareStatement(selectAll);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                User user=new User();
                user.setId_user(rs.getInt("id_user"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setCreated_at(rs.getString("created_at"));
                list.add(user);
            }
            connection.commit();
           return list;
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            throw new CakeAppException(ex.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(pst!=null){
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void deleteUser(Integer id) throws CakeAppException {
        PreparedStatement pst=null;
        try {
            connection.setAutoCommit(false);
            pst=connection.prepareStatement(delete);
            pst.setInt(1, id);
            pst.executeUpdate();           
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            throw new CakeAppException(ex.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(pst!=null){
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
