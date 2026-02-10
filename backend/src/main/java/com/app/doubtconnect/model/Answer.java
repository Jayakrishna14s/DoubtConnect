package com.app.doubtconnect.model;


import jakarta.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doubt_id", nullable = false)
    private Doubt doubt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "answered_by",
            referencedColumnName = "username",
            nullable = false
    )
    private User user;
}
