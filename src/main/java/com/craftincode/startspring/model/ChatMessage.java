package com.craftincode.startspring.model;

import java.time.OffsetDateTime;

public class ChatMessage {
    private OffsetDateTime date;
    private String author;
    private String text;

    public ChatMessage(){}

    public ChatMessage(String author, String text) {
        this.author = author;
        this.text = text;
        this.date = OffsetDateTime.now();
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "date=" + date +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
