package com.spring.batch.practice.springbatchpractice.domain;


import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Person {

    private String lastName;
    private String firstName;

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "firstName: "+ firstName + ", lastName: "+lastName;
    }
}
