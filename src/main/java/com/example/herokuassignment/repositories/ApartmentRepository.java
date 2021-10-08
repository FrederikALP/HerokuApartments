package com.example.herokuassignment.repositories;

import com.example.herokuassignment.models.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}
