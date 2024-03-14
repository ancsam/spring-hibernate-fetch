package com.example.demo.service;

import com.example.demo.dao.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.MechanicRepository;
import com.example.demo.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    public final CarRepository carRepository;
    public final MechanicRepository mechanicRepository;
    public final CompanyRepository companyRepository;

    public CarService(CarRepository carRepository, MechanicRepository mechanicRepository, CompanyRepository companyRepository) {
        this.carRepository = carRepository;
        this.mechanicRepository = mechanicRepository;
        this.companyRepository = companyRepository;
    }

    @Transactional
    public Car saveAndFetchEager(Car car) {
        Car saved = carRepository.save(car);
        return carRepository.findByIdEager(saved.getId());
    }

}
