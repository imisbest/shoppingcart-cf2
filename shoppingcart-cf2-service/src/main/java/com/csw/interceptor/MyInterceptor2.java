package com.csw.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor2 implements Interceptor {
    @Override
    public String intercept(ActionInvocation ai) throws Exception {

        ai.invoke();
        return null;

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
