package com.codedifferently.maintanencerequestserver.domain.core.maintenanceRequest.repos;

import com.codedifferently.maintanencerequestserver.domain.core.maintenanceRequest.models.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaintenanceRequestRepo extends JpaRepository<MaintenanceRequest, Long> {
    Optional<MaintenanceRequest> findByAptNumber(String number);
    Optional<MaintenanceRequest> findByEmail(String email);
}
