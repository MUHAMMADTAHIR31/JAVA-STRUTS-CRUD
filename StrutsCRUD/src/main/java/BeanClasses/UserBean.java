/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanClasses;

/**
 *
 * @author Dell
 */
public class UserBean  {

    private String fname,lname,email;
    private int mobile, userid;
    
    public String getFname() {
     return fname;
    }
    
    public void setFname(String fname) {
     this.fname = fname;
    }
    
    public String getLname() {
     return lname;
    }
    
    public void setLname(String lname) {
     this.lname = lname;
    }
    
    public String getEmail() {
     return email;
    }
    
    public void setEmail(String email) {
     this.email = email;
    }
    
    public int getMobile() {
     return mobile;
    }
    
    public void setMobile(int mobile) {
     this.mobile = mobile;
    }

    public int getUserid() {
     return userid;
    }
    
    public void setUserid(int userid) {
     this.userid = userid;
    }
}
