package com.codedifferently.maintanencerequestserver.domain.core.maintenanceRequest.services;

import com.codedifferently.maintanencerequestserver.domain.core.exceptions.ResourceCreationException;
import com.codedifferently.maintanencerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.codedifferently.maintanencerequestserver.domain.core.maintenanceRequest.models.MaintenanceRequest;
import com.codedifferently.maintanencerequestserver.domain.core.maintenanceRequest.repos.MaintenanceRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceRequestServiceImpl implements MaintenanceRequestService{

    private  MaintenanceRequestRepo maintenanceRequestRepo;

    @Autowired
    public MaintenanceRequestServiceImpl(MaintenanceRequestRepo maintenanceRequestRepo) {
        this.maintenanceRequestRepo = maintenanceRequestRepo;
    }

    @Override
    public MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException {
        Optional<MaintenanceRequest> optional = maintenanceRequestRepo.findById(maintenanceRequest.getId());
        if(optional.isPresent()){
            throw new ResourceCreationException("There is already an active maintenance request at id "+maintenanceRequest.getId());
        }
        maintenanceRequest = maintenanceRequestRepo.save(maintenanceRequest);
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getById(Long id) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No Maintenance Request associated at id: "+id));
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException("No Maintenance Request associated with email: "+email));
        return maintenanceRequest;
    }

    @Override
    public List<MaintenanceRequest> getAll() {
        return maintenanceRequestRepo.findAll();
    }

    @Override
    public MaintenanceRequest update(Long id, MaintenanceRequest maintenanceRequestDetail) throws ResourceNotFoundException{
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No Maintenance Request associated at id: "+id));
        maintenanceRequest.setFirstName(maintenanceRequestDetail.getFirstName());
        maintenanceRequest.setLastName(maintenanceRequestDetail.getLastName());
        maintenanceRequest.setAptNumber(maintenanceRequestDetail.getAptNumber());
        maintenanceRequest.setEmail(maintenanceRequestDetail.getEmail());
        maintenanceRequest.setDescription(maintenanceRequestDetail.getDescription());
        maintenanceRequest.setCreatedAt(maintenanceRequestDetail.getCreatedAt());
        maintenanceRequest = maintenanceRequestRepo.save(maintenanceRequest);
        return maintenanceRequest;
    }

    @Override
    public void delete(Long id) {
        maintenanceRequestRepo.delete(getById(id));
    }
}
