package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class ConstitutiveRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,length =255)
    private String subjective;
    @Column(length =255)
    private String objective;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjective() {
        return subjective;
    }

    public void setSubjective(String subjective) {
        this.subjective = subjective;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public ConstitutiveRequirement(String subjective, String objective) {
        this.subjective = subjective;
        this.objective = objective;
    }
}
