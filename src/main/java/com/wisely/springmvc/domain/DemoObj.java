package com.wisely.springmvc.domain;

/**
 * Created by dujiayong on 2016/7/6.
 */
public class DemoObj {

    private Long id;
    private String name;

    public DemoObj(){
        //jackson对对象和json做转换时一定需要此空构造
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DemoObj(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
