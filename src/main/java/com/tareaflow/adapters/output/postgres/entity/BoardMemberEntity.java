package com.tareaflow.adapters.output.postgres.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "board_members")
public class BoardMemberEntity {

    @Id
    private UUID id;

    @Column(name = "board_id")
    private UUID boardId;

    @Column(name = "user_id")
    private UUID userId;

    private String role;

    @Column(name = "invited_at")
    private java.sql.Timestamp invitedAt;

    public BoardMemberEntity() {}

    // Getters y setters si los necesitas
}
