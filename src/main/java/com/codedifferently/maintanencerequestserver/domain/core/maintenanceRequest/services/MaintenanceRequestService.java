package com.codedifferently.maintanencerequestserver.domain.core.maintenanceRequest.services;

import com.codedifferently.maintanencerequestserver.domain.core.exceptions.ResourceCreationException;
import com.codedifferently.maintanencerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.codedifferently.maintanencerequestserver.domain.core.maintenanceRequest.models.MaintenanceRequest;

import java.util.List;

public interface MaintenanceRequestService {
    MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException;
    MaintenanceRequest getById(Long id) throws ResourceNotFoundException;
    MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException;
    List<MaintenanceRequest> getAll();
    MaintenanceRequest update(Long id, MaintenanceRequest maintenanceRequestDetail) throws  ResourceNotFoundException;
    void delete(Long id);
}
