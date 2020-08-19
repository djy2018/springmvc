package com.wisely.highlight_springmvc4.service.impl.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassA {

    @Autowired
    ClassB classB;

//    public ClassA(ClassB classB) {
//        this.classB = classB;
//    }

}
