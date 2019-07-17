package com.tw.apistackbase.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CriminalCase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long time;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
    public CriminalCase(String name, Long time) {
        this.name = name;
        this.time = time;
    }
}
