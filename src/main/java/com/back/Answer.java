package com.back;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    @ManyToOne
    private Question question;
}