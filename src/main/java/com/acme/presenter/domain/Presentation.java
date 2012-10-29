package com.acme.presenter.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Presentation {

    @Enumerated
    private Status status;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Component> elements = new HashSet<Component>();
}
