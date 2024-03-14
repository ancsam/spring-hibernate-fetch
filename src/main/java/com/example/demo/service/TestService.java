package com.example.demo.service;

import com.example.demo.dao.Car;
import com.example.demo.dao.Mechanic;
import com.example.demo.dao.Company;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final CarService carService;
    private final MechanicService mechanicService;
    private final CompanyService companyService;

    public TestService(CarService demoService, MechanicService mechanicService, CompanyService companyService) {
        this.carService = demoService;
        this.mechanicService = mechanicService;
        this.companyService = companyService;
    }

    @PostConstruct
    public void doTestFetch() {
        // prepare FK's
        Company company = companyService.save("company1");
        Mechanic mechanic = mechanicService.save("mechanic1", company);

        // prepare Car entity
        Car car = new Car();
        car.setName("car1");
        car.setMechanic(mechanicService.findById(mechanic.getId())); // mark 1

        // ... additional logic here ...

        Car carEager = carService.saveAndFetchEager(car); // should return eager
        System.out.println(carEager.getMechanic().getCompany().getName()); // FAIL with LazyInitializationException, why???
    }
}
