/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts.dao;

/**
 *
 * @author Dell
 */
import BeanClasses.UserBean;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
public class UserDAO {

    public List<UserBean> getAllUserBean() {
        
        List<UserBean> li = new ArrayList<>();
        try {
            
            Connection con=DBconnection.getConnection();
            Statement st=con.createStatement();
            String sql="SELECT UserId,FirstName ,LastName ,EmailId,MobileNo  FROM UserDetails ";
            ResultSet rs = st.executeQuery(sql);        
            UserBean urb = new UserBean();

            while (rs.next()) {
                    
                urb = new UserBean();
                urb.setUserid(rs.getInt("UserId")); 
                urb.setFname(rs.getString("FirstName"));
                urb.setLname(rs.getString("LastName"));
                urb.setEmail(rs.getString("EmailId"));
                urb.setMobile(rs.getInt("MobileNo"));
                
                li.add(urb);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return li;
    }
 
    public void adduser(UserBean urb) {
        
        try {
            Connection con=DBconnection.getConnection();
            String sql="insert into UserDetails (FirstName,LastName,EmailId,MobileNo) values(?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
   
            ps.setString(1, urb.getFname());
            ps.setString(2, urb.getLname());
            ps.setString(3, urb.getEmail());
            ps.setInt(4, urb.getMobile());    
            ps.executeUpdate();
        }catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
 
 
    public void updateUser(UserBean urb)  {
       
        try {
            Connection con=DBconnection.getConnection();
            String sql ="update UserDetails set FirstName=? ,LastName=? ,EmailId=?,MobileNo=? where UserId=? ";
            PreparedStatement ps=con.prepareStatement(sql);
   
            ps.setString(1, urb.getFname());
            ps.setString(2, urb.getLname());
            ps.setString(3, urb.getEmail());
            ps.setInt(4, urb.getMobile());
            ps.setInt(5, urb.getUserid());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void deleteUser(int Userid) {
       
        try {
            Connection con=DBconnection.getConnection();
            String sql="delete from UserDetails where UserId=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, Userid);   
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
