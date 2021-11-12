/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andrirynaldi.cakeapp.controller;

import com.andrirynaldi.cakeapp.error.CakeAppException;
import com.andrirynaldi.cakeapp.model.RegisterModel;
import com.andrirynaldi.cakeapp.view.SignUpForm;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author andri
 */
public class SignupController {

    RegisterModel model;

    public SignupController(RegisterModel model) {
        this.model = model;
    }

    public void signUp(SignUpForm view) {
        String fullname = view.getTxtFullName().getText();
        String email = view.getTxtEmail().getText();
        String password = view.getTxtPassword().getText();
        String role=view.getComboRole().getSelectedItem().toString();
        if (fullname.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama lengkap harus diisi");
        } else if (email.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Email harus diisi");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        } else if (password.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Password harus diisi");
        } else if (password.trim().length() < 6) {
            JOptionPane.showMessageDialog(view, "Password harus minimal 6 karakter");

        } else {
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            model.setFullname(fullname);
            model.setEmail(email);
            model.setPassword(password);
            model.setCreated_at(strDate);
            model.setRole(role);
            try {
                model.signUp();
                JOptionPane.showMessageDialog(view, "Berhasil didaftarkan, silahkan login");
                model.resetForm();
            } catch (SQLException | CakeAppException ex) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi error :", ex.getMessage()});
            }
        }

    }
    
    public void resetForm(SignUpForm view)
    {
        model.resetForm();
    }
}
