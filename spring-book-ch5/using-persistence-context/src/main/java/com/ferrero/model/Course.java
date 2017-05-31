package com.ferrero.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by drugo on 31/05/2017.
 */
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
