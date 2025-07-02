package com.auth_application.auth.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.UUID;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
@Document(collection = "user_auth")
public class UserDocumentEntity {

//    @Id
    @MongoId // this annotation to understand to mongo that this field is the id
    private String userId;  // we need to use String because of the way the mongodb driver works
//    private UUID userId;
    private String email;
    private String userName;
    private String password;
    private Boolean isVerified;
    private LocalDateTime created;
    private LocalDateTime lastLogin;
}
