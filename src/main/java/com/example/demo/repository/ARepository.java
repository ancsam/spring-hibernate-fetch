package com.example.demo.repository;

import com.example.demo.dao.A;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ARepository  extends JpaRepository<A,Long> {
    @Query("select a from A a left join fetch a.b b left join fetch b.c where a.id = :id")
    A findByIdEager(Long id);
}
