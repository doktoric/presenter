// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.acme.presenter.domain;

import com.acme.presenter.domain.Component;
import com.acme.presenter.domain.Presentation;
import com.acme.presenter.domain.Status;
import java.util.Set;

privileged aspect Presentation_Roo_JavaBean {
    
    public Status Presentation.getStatus() {
        return this.status;
    }
    
    public void Presentation.setStatus(Status status) {
        this.status = status;
    }
    
    public String Presentation.getName() {
        return this.name;
    }
    
    public void Presentation.setName(String name) {
        this.name = name;
    }
    
    public Set<Component> Presentation.getElements() {
        return this.elements;
    }
    
    public void Presentation.setElements(Set<Component> elements) {
        this.elements = elements;
    }
    
}
