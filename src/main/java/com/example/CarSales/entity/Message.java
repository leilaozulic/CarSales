package com.example.CarSales.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.sql.Timestamp;

@Entity
public class Message {

    // Message
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Conversation conversation_id;

    private String message_by;
    private String content;

    private java.sql.Timestamp delivered_at;
    private java.sql.Timestamp seen_at;
    private java.sql.Timestamp created_at;

    public Message() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Conversation getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(Conversation conversation_id) {
        this.conversation_id = conversation_id;
    }

    public String getMessage_by() {
        return message_by;
    }

    public void setMessage_by(String message_by) {
        this.message_by = message_by;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDelivered_at() {
        return delivered_at;
    }

    public void setDelivered_at(Timestamp delivered_at) {
        this.delivered_at = delivered_at;
    }

    public Timestamp getSeen_at() {
        return seen_at;
    }

    public void setSeen_at(Timestamp seen_at) {
        this.seen_at = seen_at;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
