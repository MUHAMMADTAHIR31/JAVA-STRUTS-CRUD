/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.controller;

import BeanClasses.UserBean;
import com.opensymphony.xwork2.ActionSupport;
import com.struts.dao.UserDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class UserController extends ActionSupport {
 
    private static final long serialVersionUID = -6239703166715154765L;
    private List<UserBean> userlists=new ArrayList<>();
  
    private UserDAO ub=new UserDAO();
    private UserBean urb=new UserBean();
    
    public String alluserlist() throws Exception {
        this.userlists=this.ub.getAllUserBean();
        return SUCCESS;
    }
    
    public String adduser(){
        this.ub.adduser(this.urb);
        this.userlists=this.ub.getAllUserBean();
        this.urb=new UserBean();
        return SUCCESS;
    }
    
    public String userupdate(){
        
        this.ub.updateUser(this.urb);
        this.userlists=this.ub.getAllUserBean();
        this.urb=new UserBean();

        return SUCCESS;
    }
    
    
    public String userdelete(){
   
        this.ub.deleteUser(urb.getUserid());
        this.userlists=this.ub.getAllUserBean();
        this.urb=new UserBean();

        return SUCCESS;
    }
    
    public UserDAO getUb() {
        return ub;
    }

    public void setUb(UserDAO ub) {
         this.ub = ub;
    }

    public UserBean getUrb() {
        return urb;
    }

    public void setUrb(UserBean urb) {
        this.urb = urb;
    }

    public List<UserBean> getUserlists() {
        return userlists;
    }

    public void setUserlists(List<UserBean> userlists) {
        this.userlists = userlists;
    }   
}
