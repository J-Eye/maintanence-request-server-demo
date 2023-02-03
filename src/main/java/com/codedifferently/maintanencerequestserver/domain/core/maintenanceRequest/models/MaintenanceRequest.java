package com.codedifferently.maintanencerequestserver.domain.core.maintenanceRequest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class MaintenanceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @NonNull
    String firstName;

    @NonNull
    String lastName;

    @NonNull
    String email;

    @NonNull
    String aptNumber;

    @NonNull
    String description;

    @NonNull
    Date createdAt;

    @Override
    public String toString() {
        return  "Id:"+Id+
                "firstName:"+firstName+
                "lastName:"+lastName+
                "email:"+email+
                "aptNumber:"+aptNumber+
                "description"+description+
                "createdAt"+createdAt;
        //return String.format("%d,%s,%s,%s,%s,%s,t",Id,firstName,lastName,email,aptNumber,description,createdAt);
    }
}
