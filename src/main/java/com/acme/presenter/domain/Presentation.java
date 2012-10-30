package com.acme.presenter.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

@Configurable
@Entity
@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Presentation {

    @Enumerated
    private Status status;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Component> elements = new HashSet<Component>();

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
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

	public Status getStatus() {
        return this.status;
    }

	public void setStatus(Status status) {
        this.status = status;
    }

	public String getName() {
        return this.name;
    }

	public void setName(String name) {
        this.name = name;
    }

	public Set<Component> getElements() {
        return this.elements;
    }

	public void setElements(Set<Component> elements) {
        this.elements = elements;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Presentation().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countPresentations() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Presentation o", Long.class).getSingleResult();
    }

	public static List<Presentation> findAllPresentations() {
        return entityManager().createQuery("SELECT o FROM Presentation o", Presentation.class).getResultList();
    }

	public static Presentation findPresentation(Long id) {
        if (id == null) return null;
        return entityManager().find(Presentation.class, id);
    }

	public static List<Presentation> findPresentationEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Presentation o", Presentation.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Presentation attached = Presentation.findPresentation(this.id);
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
    public Presentation merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Presentation merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
