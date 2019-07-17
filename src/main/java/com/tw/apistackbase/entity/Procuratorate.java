package com.tw.apistackbase.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Procuratorate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50,unique = true,nullable = false)
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Procurator> procurator;

    public Procuratorate(String name, List<Procurator> procurator) {
        this.name = name;
        this.procurator = procurator;
    }

    public List<Procurator> getProcurator() {
        return procurator;
    }

    public void setProcurator(List<Procurator> procurator) {
        this.procurator = procurator;
    }

    public Procuratorate(String name) {
        this.name = name;
    }

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
}
