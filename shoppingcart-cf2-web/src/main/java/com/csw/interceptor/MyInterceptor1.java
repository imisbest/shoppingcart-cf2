package com.csw.interceptor;

import com.csw.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyInterceptor1 implements Interceptor {
    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        // TODO Auto-generated method stub
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        User user2 = (User) session.getAttribute("acc");
        if (user2 == null) {
            return "login";
        } else {
            ai.invoke();
            return null;
        }
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void init() {
        // TODO Auto-generated method stub

    }

}
