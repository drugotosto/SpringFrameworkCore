package com.ferrero.model;

/**
 * Created by drugo on 31/05/2017.
 */
import javax.persistence.GeneratedValue;
import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
