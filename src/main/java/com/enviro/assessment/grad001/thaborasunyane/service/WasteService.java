package com.enviro.assessment.grad001.thaborasunyane.service;

import com.enviro.assessment.grad001.thaborasunyane.dto.WasteDTO;
import com.enviro.assessment.grad001.thaborasunyane.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.thaborasunyane.model.Waste;
import com.enviro.assessment.grad001.thaborasunyane.repository.WasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteService {

    @Autowired
    private WasteRepository wasteRepository;

    public List<Waste> getAllWasteItems() {
        return wasteRepository.findAll();
    }

    public Waste getWasteByName(String name) {
        return wasteRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Waste item not found: " + name));
    }

    public Waste createWaste(WasteDTO wasteDTO) {
        Waste waste = new Waste(null, wasteDTO.getName(), wasteDTO.getDisposal(), wasteDTO.getRecyclingTips(), wasteDTO.getCategory());
        return wasteRepository.save(waste);
    }

    public Waste updateWaste(Long id, WasteDTO wasteDTO) {
        Waste waste = wasteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste item not found with ID: " + id));

        waste.setName(wasteDTO.getName());
        waste.setDisposal(wasteDTO.getDisposal());
        waste.setRecyclingTips(wasteDTO.getRecyclingTips());
        waste.setCategory(wasteDTO.getCategory());

        return wasteRepository.save(waste);
    }

    public void deleteWaste(Long id) {
        if (!wasteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Waste item not found with ID: " + id);
        }
        wasteRepository.deleteById(id);
    }

    public Waste getWasteById(Long id) {
        return wasteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Waste item not found with ID: " + id));
    }
}


