package com.acme.presenter.domain;

import javax.persistence.Enumerated;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class PresentationElement {

    @Enumerated
    private ElementType status;
}