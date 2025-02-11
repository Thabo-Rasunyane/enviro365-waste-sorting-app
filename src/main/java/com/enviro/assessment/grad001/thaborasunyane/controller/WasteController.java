package com.enviro.assessment.grad001.thaborasunyane.controller;

import com.enviro.assessment.grad001.thaborasunyane.dto.WasteDTO;
import com.enviro.assessment.grad001.thaborasunyane.model.Waste;
import com.enviro.assessment.grad001.thaborasunyane.service.WasteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste")
public class WasteController {

    @Autowired
    private WasteService wasteService;

    @GetMapping
    public List<Waste> getAllWasteItems() {
        return wasteService.getAllWasteItems();
    }

    @GetMapping("/id/{id}")
    public Waste getWasteById(@PathVariable Long id) {
        return wasteService.getWasteById(id);
    }

    @GetMapping("/name/{name}")
    public Waste getWasteByName(@PathVariable String name) {
        return wasteService.getWasteByName(name);
    }

    @PostMapping
    public Waste createWaste(@Valid @RequestBody WasteDTO wasteDTO) {
        return wasteService.createWaste(wasteDTO);
    }

    @PutMapping("/id/{id}")
    public Waste updateWaste(@PathVariable Long id, @Valid @RequestBody WasteDTO wasteDTO) {
        return wasteService.updateWaste(id, wasteDTO);
    }

    @DeleteMapping("/id/{id}")
    public String deleteWaste(@PathVariable Long id) {
        wasteService.deleteWaste(id);
        return "Waste item deleted successfully!";
    }
}



//URI to get record by ID = http://localhost:8080/api/waste/id/1