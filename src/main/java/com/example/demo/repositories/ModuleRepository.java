package com.example.demo.repositories;

import com.example.demo.entities.ModulePrj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<ModulePrj, Long> {
}
