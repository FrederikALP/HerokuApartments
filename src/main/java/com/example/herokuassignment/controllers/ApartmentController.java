package com.example.herokuassignment.controllers;

import com.example.herokuassignment.models.Apartment;
import com.example.herokuassignment.repositories.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApartmentController {

    @Autowired
    ApartmentRepository apartments;

    @GetMapping("/apartments")
    public Iterable<Apartment> getApartments() {
        return apartments.findAll();
    }

    @GetMapping("/apartments/{id}")
    public Apartment getApartment(@PathVariable Long id) {
        return apartments.findById(id).get();
    }

    @PostMapping("/apartments")
    public Apartment addApartment(@RequestBody Apartment newApartment) {
        newApartment.setId(null);
        return apartments.save(newApartment);
    }

    @PutMapping("/apartments/{id}")
    public String updateApartmentById(@PathVariable Long id, @RequestBody Apartment apartmentToUpdateWith) {
        if (apartments.existsById(id)) {
            apartmentToUpdateWith.setId(id);
            apartments.save(apartmentToUpdateWith);
            return "Apartment was created";
        } else {
            return "Apartment not found";
        }
    }

    @PatchMapping("/apartments/{id}")
    public String patchApartmentsById(@PathVariable Long id, @RequestBody Apartment apartmentToUpdateWith) {
        return apartments.findById(id).map(foundApartment -> {
            if (apartmentToUpdateWith.getNumber() != 0) foundApartment.setNumber(apartmentToUpdateWith.getNumber());
            if (apartmentToUpdateWith.getFloor() != 0) foundApartment.setFloor(apartmentToUpdateWith.getFloor());
            if (apartmentToUpdateWith.getSize() != 0) foundApartment.setSize(apartmentToUpdateWith.getSize());
            if (apartmentToUpdateWith.getFamilyName() != null) foundApartment.setFamilyName(apartmentToUpdateWith.getFamilyName());

            apartments.save(foundApartment);
            return "Apartment updated";
        }).orElse("Apartment not found");
    }

    @DeleteMapping("/aprtments/{id}")
    public void deleteApartmentById(@PathVariable Long id) {
        apartments.deleteById(id);
    }
}
