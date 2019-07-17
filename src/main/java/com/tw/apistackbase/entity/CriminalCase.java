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
    private long time;


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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
    public CriminalCase(String name, long time) {
        this.name = name;
        this.time = time;
    }
}
