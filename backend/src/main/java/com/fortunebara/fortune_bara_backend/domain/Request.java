package com.fortunebara.fortune_bara_backend.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String endpoint;

    @Lob
    private String requestPayload;

    @Lob
    private String responsePayload;

    private LocalDateTime createdAt;
}
