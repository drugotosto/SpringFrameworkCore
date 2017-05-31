package spittr.model;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * Created by drugo on 18/05/2017.
 */

/*
    Spittle is a basic POJO dao object—nothing complicated. The only thing to note
    is that you’re using Apache Commons Lang for easy implementation of the equals() and hashCode() methods.
    They’ll be valuable in writing a test for the controller handler method.
 */
@Entity
@Table(name = "spittle")
public class Spittle {

    @Id
    @GeneratedValue
    private Long id;

    private String message;
    private Date time;
    private Double latitude;
    private Double longitude;

    public Spittle() {}

    public Spittle(String message, Date time) {
        this(message, time, null, null);
    }

    public Spittle(String message, Date time, Double longitude, Double latitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public long getId() {
        return id;
    }
    public String getMessage() {
        return message;
    }
    public Date getTime() {
        return time;
    }
    public Double getLongitude() {
        return longitude;
    }
    public Double getLatitude() {
        return latitude;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }


}