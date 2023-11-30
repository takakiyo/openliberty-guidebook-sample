package com.demo.bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped
@Named("request")
public class RequestScopedBean extends BaseBean {
    @Override
    String getName() {
        return "RequestScopedBean";
    }
}
