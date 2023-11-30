package com.demo.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class BaseBean implements Serializable {
    private LocalDateTime created;
    protected BaseBean() {
        created = LocalDateTime.now();
    }
    abstract String getName();
    public String getInfo() {
        return getName() + "(id=" + System.identityHashCode(this) + ") created at " + created;
    }
}
