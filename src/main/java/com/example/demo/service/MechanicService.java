package com.example.demo.service;

import com.example.demo.dao.Mechanic;
import com.example.demo.dao.Company;
import com.example.demo.repository.MechanicRepository;
import org.springframework.stereotype.Service;

@Service
public class MechanicService {

    private final MechanicRepository mechanicRepository;

    public MechanicService(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    public Mechanic save(String name, Company company) {
        Mechanic mechanic = new Mechanic();
        mechanic.setName(name);
        mechanic.setCompany(company);
        return mechanicRepository.save(mechanic);
    }

    public Mechanic findById(Long id) {
        return mechanicRepository.findById(id).orElse(null);
    }
}
