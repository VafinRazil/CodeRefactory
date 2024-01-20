package com.rvafin.springjwt.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTimeCreate;
    @Column(columnDefinition = "TEXT")
    private String requestCode;
    @Column(columnDefinition = "TEXT")
    private String responseCode;
    private String programmingLanIndex;

    @ManyToOne
    @JoinColumn(name = "request_creator_id")
    private User requestCreator;

    public User getRequestCreator() {
        return requestCreator;
    }

    public void setRequestCreator(User requestCreator) {
        this.requestCreator = requestCreator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTimeCreate() {
        return dateTimeCreate;
    }

    public void setDateTimeCreate(LocalDateTime dateTimeCreate) {
        this.dateTimeCreate = dateTimeCreate;
    }

    public String getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getProgrammingLanIndex() {
        return programmingLanIndex;
    }

    public void setProgrammingLanIndex(String programmingLanIndex) {
        this.programmingLanIndex = programmingLanIndex;
    }
}
