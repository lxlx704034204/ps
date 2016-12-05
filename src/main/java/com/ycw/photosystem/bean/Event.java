package com.ycw.photosystem.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by liuyang on 2016/11/25 0025.
 */
@Entity
public class Event {
    private int id;
    private Integer eventUser;
    private String eventMsg;
    private Timestamp eventTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "event_user", nullable = true)
    public Integer getEventUser() {
        return eventUser;
    }

    public void setEventUser(Integer eventUser) {
        this.eventUser = eventUser;
    }

    @Basic
    @Column(name = "event_msg", nullable = true, length = 255)
    public String getEventMsg() {
        return eventMsg;
    }

    public void setEventMsg(String eventMsg) {
        this.eventMsg = eventMsg;
    }

    @Basic
    @Column(name = "event_time", nullable = true)
    public Timestamp getEventTime() {
        return eventTime;
    }

    public void setEventTime(Timestamp eventTime) {
        this.eventTime = eventTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        if (eventUser != null ? !eventUser.equals(event.eventUser) : event.eventUser != null) return false;
        if (eventMsg != null ? !eventMsg.equals(event.eventMsg) : event.eventMsg != null) return false;
        if (eventTime != null ? !eventTime.equals(event.eventTime) : event.eventTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (eventUser != null ? eventUser.hashCode() : 0);
        result = 31 * result + (eventMsg != null ? eventMsg.hashCode() : 0);
        result = 31 * result + (eventTime != null ? eventTime.hashCode() : 0);
        return result;
    }
}
