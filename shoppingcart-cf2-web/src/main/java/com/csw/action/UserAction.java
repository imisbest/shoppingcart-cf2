package com.csw.action;

import com.csw.entity.Product;
import com.csw.entity.User;
import com.csw.service.UserService;
import com.csw.service.UserServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class UserAction {
    private String username;
    private String password;
    private String name;
    private Integer zip;
    private String address;
    private User user;

    public String Login() {
        HttpServletRequest request = ServletActionContext.getRequest();
        System.out
                .println("welcome to Login$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        UserService userService = new UserServiceImpl();
        User acc = userService.queryBy(username, password);
        if (acc == null || username == null || password == null) {

            return "false";
        } else {
            HttpSession session = request.getSession();
            Map<Product, Integer> map = new HashMap<Product, Integer>();
            Map<Product, Integer> mapSub = new HashMap<Product, Integer>();
            Map<Product, Integer> mapEnd = new HashMap<Product, Integer>();

            session.setAttribute("map", map);
            session.setAttribute("mapSub", mapSub);
            session.setAttribute("mapEnd", mapEnd);

            session.setAttribute("acc", acc);
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            request.setAttribute("username", username);
            return "true";
        }

    }

    public String CreateUserAction() {
        HttpServletRequest request = ServletActionContext.getRequest();
        System.out
                .println("welcome to CreateUserAction$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");
        UserService userService = new UserServiceImpl();
        User uu = new User(username, pass1, name, zip, address);
        System.out.println("username" + username);
        System.out.println("pass1" + pass1);
        if (!pass1.equals(pass2) || username == null || username.length() <= 0 || pass1 == null || pass1.length() <= 0) {
            return "false";
        } else {

            userService.addUsers(uu);
            return "true";
        }
    }

    public String SafeOut() {
        HttpServletRequest request = ServletActionContext.getRequest();
        System.out
                .println("welcome to SafeOut$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        HttpSession session = request.getSession();
        session.invalidate();
        return "safe";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
