package com.weather.service;

import com.weather.model.DTO.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, String> {
}
