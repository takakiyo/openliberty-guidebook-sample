package com.demo.bean;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("application")
public class ApplicationScopedBean extends BaseBean {
    @Override
    String getName() {
        return "ApplicationScopedBean";
    }
}
