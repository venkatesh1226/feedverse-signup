package com.feedverse.authenticator.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_user_id")
    private DBUser source; // The user who initiates the connection (follows)

    @ManyToOne
    @JoinColumn(name = "target_user_id")
    private DBUser target; // The user who is the target of the connection (is followed)

    private LocalDate since;
    // Constructors, getters, setters

    public Connection() {
    }

    public Connection(DBUser source, DBUser target, LocalDate since) {
        this();
        this.target = target;
        this.since = since;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DBUser getSource() {
        return source;
    }

    public void setSource(DBUser source) {
        this.source = source;
    }

    public DBUser getTarget() {
        return target;
    }

    public void setTarget(DBUser target) {
        this.target = target;
    }

    public LocalDate getSince() {
        return since;
    }

    public void setSince(LocalDate since) {
        this.since = since;
    }

    @Override
    public String toString() {
        return "Connection [id=" + id + ", source=" + source + ", target=" + target + ", since=" + since + "]";
    }

    // Getters and setters for id, target, and since

}
