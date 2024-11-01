package com.auth_application.auth.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document(collection = "user_auth")
public class UserDocumentEntity {

    @Id
    private UUID userId;
    private String email;
    private String userName;
    private String password;
    private Boolean isVerified;
    private LocalDateTime created;
    private LocalDateTime lastLogin;
}
