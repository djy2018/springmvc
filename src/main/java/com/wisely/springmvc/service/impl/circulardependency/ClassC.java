package com.wisely.springmvc.service.impl.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassC {

    @Autowired
    ClassA classA;

//    public ClassC(ClassA classA){
//        this.classA = classA;
//    }

}
