package com.practos.hospital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Footer {

    @Id
    @GeneratedValue
    private Long id;
    private String heading;
    private String link;
    private String category;
    public Footer() {
    }

    public Footer(String heading, String link, String category) {
        this.heading = heading;
        this.link = link;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getLink() {
        return link;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLink(String link) {
        this.link = link;
    }
    @Override
    public String toString() {
        return "Footer{" +
                "id=" + id +
                ", heading='" + heading + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

}
