package com.acme.presenter.domain;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.mail.MailSender;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.acme.presenter.domain.Adress;
import com.acme.presenter.domain.Roles;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class PresenterUser {

  

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar birthDate;

    private Boolean enable;

    @ManyToOne
    private Adress adress;

    @ElementCollection
    private Set<Roles> roles = new HashSet<Roles>();
}
