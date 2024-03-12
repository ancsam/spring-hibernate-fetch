package com.example.demo.service;

import com.example.demo.dao.A;
import com.example.demo.dao.B;
import com.example.demo.dao.C;
import com.example.demo.repository.ARepository;
import com.example.demo.repository.BRepository;
import com.example.demo.repository.CRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public final ARepository aRepository;
    public final BRepository bRepository;
    public final CRepository cRepository;

    public DemoService(ARepository aRepository, BRepository bRepository, CRepository cRepository) {
        this.aRepository = aRepository;
        this.bRepository = bRepository;
        this.cRepository = cRepository;
    }

    @Transactional
    public A saveA(A a) {
        A saved = aRepository.save(a);
        return aRepository.findByIdEager(saved.getId());
    }

    public C saveC(String name) {
        C c = new C();
        c.setName(name);
        return cRepository.save(c);
    }

    public B saveB(String name, C c) {
        B b = new B();
        b.setName(name);
        b.setC(c);
        return bRepository.save(b);
    }

    public B findById(Long id) {
        return bRepository.findById(id).orElse(null);
    }

}
