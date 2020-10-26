package com.example.entreprise.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;

import java.time.Instant;


import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table
public class Offer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;


    @Column
    private String title;


    @Nullable
    @Lob
    @Column
    private String profil;

    @Nullable
    @Lob
    @Column
    private String mission;

    @Nullable
    @Lob
    @Column
    private String qualities;

    @Nullable
    @Lob
    @Column
    private String competance;
    private Instant dateCrea;


    @Column
    private String username;


    @Column
    private String type;




    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public void setProfil(@Nullable String profil) {
        this.profil = profil;
    }

    public void setMission(@Nullable String mission) {
        this.mission = mission;
    }

    public void setQualities(@Nullable String qualities) {
        this.qualities = qualities;
    }

    public void setCompetance(@Nullable String competance) {
        this.competance = competance;
    }

    public void setDateCrea(Instant dateCrea) {
        this.dateCrea = dateCrea;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }



    @Nullable
    public String getProfil() {
        return profil;
    }

    @Nullable
    public String getMission() {
        return mission;
    }

    @Nullable
    public String getQualities() {
        return qualities;
    }

    @Nullable
    public String getCompetance() {
        return competance;
    }

    public Instant getDateCrea() {
        return dateCrea;
    }

    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }




}
