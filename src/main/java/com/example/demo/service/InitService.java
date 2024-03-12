package com.example.demo.service;

import com.example.demo.dao.A;
import com.example.demo.dao.B;
import com.example.demo.dao.C;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class InitService {

    private final DemoService demoService;

    public InitService(DemoService demoService) {
        this.demoService = demoService;
    }

    @PostConstruct
    public void doTestFetch() {
        // prepare FK data
        C c = demoService.saveC("c");
        B b = demoService.saveB("b", c);
        // prepare A entity
        A a = new A();
        a.setName("a");
        a.setB(demoService.findById(b.getId()));

        // save and fetch eager
        A aEager = demoService.saveA(a); // should return A
        System.out.println(aEager.getB().getC().getName()); // FAIL with LazyInitializationException, why???
    }
}
