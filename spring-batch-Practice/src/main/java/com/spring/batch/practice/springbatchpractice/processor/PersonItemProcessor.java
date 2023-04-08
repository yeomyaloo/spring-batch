package com.spring.batch.practice.springbatchpractice.processor;

import com.spring.batch.practice.springbatchpractice.domain.Person;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import org.slf4j.Logger;

/**
 * 중간 프로세서로 데이터를 가공하거나 필터링할 때 사용합니다.
 * 이는 필수가 아니기 때문에 writer부분에서도 구현이 가능하다.
 * 이를 쓰는 이유는 비지니스 코드가 섞이는 것을 막기 위함이다.
 *
 * 변환/필터
 *
 * 이름 대문자 -> 소문자 변경
 *
 * */
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);


    /**
     * 이름을 대문자로 변경해서 전달해주는 변환 작업을 여기서 진행.
     * */
    @Override
    public Person process(final Person person) throws Exception {
        String firstName = person.getFirstName().toUpperCase();
        String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = new Person(firstName, lastName);
        log.info("Converting (" + person + ") into (" + transformedPerson + ")");
        return transformedPerson;
    }
}
