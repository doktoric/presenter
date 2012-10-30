package com.acme.presenter.domain;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.mail.MailSender;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

import com.acme.presenter.domain.Adress;
import com.acme.presenter.domain.Roles;

@Configurable
@Entity
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

	public String getFirstName() {
        return this.firstName;
    }

	public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

	public String getLastName() {
        return this.lastName;
    }

	public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public String getUserName() {
        return this.userName;
    }

	public void setUserName(String userName) {
        this.userName = userName;
    }

	public String getEmail() {
        return this.email;
    }

	public void setEmail(String email) {
        this.email = email;
    }

	public Calendar getBirthDate() {
        return this.birthDate;
    }

	public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

	public Boolean getEnable() {
        return this.enable;
    }

	public void setEnable(Boolean enable) {
        this.enable = enable;
    }

	public Adress getAdress() {
        return this.adress;
    }

	public void setAdress(Adress adress) {
        this.adress = adress;
    }

	public Set<Roles> getRoles() {
        return this.roles;
    }

	public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new PresenterUser().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countPresenterUsers() {
        return entityManager().createQuery("SELECT COUNT(o) FROM PresenterUser o", Long.class).getSingleResult();
    }

	public static List<PresenterUser> findAllPresenterUsers() {
        return entityManager().createQuery("SELECT o FROM PresenterUser o", PresenterUser.class).getResultList();
    }

	public static PresenterUser findPresenterUser(Long id) {
        if (id == null) return null;
        return entityManager().find(PresenterUser.class, id);
    }

	public static List<PresenterUser> findPresenterUserEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM PresenterUser o", PresenterUser.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Transactional
    public void persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }

	@Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            PresenterUser attached = PresenterUser.findPresenterUser(this.id);
            this.entityManager.remove(attached);
        }
    }

	@Transactional
    public void flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }

	@Transactional
    public void clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }

	@Transactional
    public PresenterUser merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        PresenterUser merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;

	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
