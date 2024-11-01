//package com.auth_application.auth.application.create;
//
//import com.auth_application.auth.domain.UserAuthDateCreated;
//import com.auth_application.auth.domain.UserAuthDateLastLogin;
//import com.auth_application.auth.domain.UserAuthEmail;
//import com.auth_application.auth.domain.UserAuthIsVerified;
//import com.auth_application.auth.domain.event.UserCreatedEvent;
//import com.auth_application.shared.domain.UserAuthId;
//import com.auth_application.shared.domain.UserAuthUserName;
//import com.auth_application.shared.domain.bus.event.DomainEventSubscriber;
//import org.springframework.stereotype.Service;
//
//@Service
//@DomainEventSubscriber({UserCreatedEvent.class})
//public class CreateUserReadOnUserWriteCreated {
//
//    private final UserReadModelRepository repository;
//
//    public CreateUserReadOnUserWriteCreated(UserReadModelRepository repository) {this.repository = repository;}
//
//    public void on(UserCreatedEvent  event) {
//            UserAuthId userId = new UserAuthId(event.getUserId());
//            UserAuthEmail email = new UserAuthEmail(event.getEmail());
//            UserAuthUserName userName = new UserAuthUserName(event.getUserName());
//            UserAuthIsVerified isVerified = new UserAuthIsVerified(false);
//            UserAuthDateCreated created = new UserAuthDateCreated(event.getCreated());
//            UserAuthDateLastLogin lastLogin = new UserAuthDateLastLogin(null);
//            UserReadModel user = new UserReadModel(userId, email, userName, isVerified, created, lastLogin);
//            repository.save(user);
//            System.out.println("User %s created: " + event.getUserId());
//
//    }
//
//}
