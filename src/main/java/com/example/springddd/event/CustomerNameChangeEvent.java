package com.example.springddd.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CustomerNameChangeEvent extends ApplicationEvent {

    private String newName;
    private Integer id;


    public CustomerNameChangeEvent(Object source, String newName, Integer id) {
        super(source);
        this.id = id;
        this.newName = newName;
    }
}
