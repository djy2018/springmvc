package com.wisely.springmvc.service.impl.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassB {

    @Autowired
    ClassC classC;

//    public ClassB(ClassC classC){
//        this.classC = classC;
//    }

}