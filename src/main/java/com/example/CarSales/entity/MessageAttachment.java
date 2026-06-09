package com.example.CarSales.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.sql.Timestamp;

@Entity
public class MessageAttachment {

    // MessageAttachment
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Message message_id;

    private String file_url;
    private String file_type;

    private java.sql.Timestamp created_at;

    public MessageAttachment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Message getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Message message_id) {
        this.message_id = message_id;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
