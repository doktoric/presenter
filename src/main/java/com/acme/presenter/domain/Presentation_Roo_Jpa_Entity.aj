// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.acme.presenter.domain;

import com.acme.presenter.domain.Presentation;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect Presentation_Roo_Jpa_Entity {
    
    declare @type: Presentation: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Presentation.id;
    
    @Version
    @Column(name = "version")
    private Integer Presentation.version;
    
    public Long Presentation.getId() {
        return this.id;
    }
    
    public void Presentation.setId(Long id) {
        this.id = id;
    }
    
    public Integer Presentation.getVersion() {
        return this.version;
    }
    
    public void Presentation.setVersion(Integer version) {
        this.version = version;
    }
    
}
