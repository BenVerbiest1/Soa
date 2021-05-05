package net.soa.springboot.crudrestfulwebservices.model;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")

    private String lastname;

    @Column(name = "placeofmeeting")
    private String meetingSpot;

    public Friend() {
        super();
    }

    public Friend(long id, String firstname, String lastname, String meetingSpot) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.meetingSpot = meetingSpot;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMeetingSpot() {
        return meetingSpot;
    }

    public void setMeetingSpot(String meetingSpot) {
        this.meetingSpot = meetingSpot;
    }
}
