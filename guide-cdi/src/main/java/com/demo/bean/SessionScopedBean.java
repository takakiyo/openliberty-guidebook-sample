package com.demo.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@SessionScoped
@Named("session")
public class SessionScopedBean extends BaseBean {
    @Override
    String getName() {
        return "SessionScopedBean";
    }
}
