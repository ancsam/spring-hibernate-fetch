package com.example.demo.repository;

import com.example.demo.dao.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    @Query("""
        select car from Car car
          left join fetch car.mechanic mechanic
          left join fetch mechanic.company
        where car.id = :id
        """)
    Car findByIdEager(Long id);
}
