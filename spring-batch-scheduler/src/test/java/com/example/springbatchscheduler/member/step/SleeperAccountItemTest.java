package com.example.springbatchscheduler.member.step;

import com.example.springbatchscheduler.member.dto.MemberIdResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RequiredArgsConstructor
@SpringBatchTest
@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SleeperAccountItem.class})
class SleeperAccountItemTest {


    @Autowired
    private JpaCursorItemReader<MemberIdResponseDto> itemReader;

    private StepExecution stepExecution;

    TestEntityManager testEntityManager;

    @BeforeEach
    void setup(){



    }

    public StepExecution getStepExecution(){
        StepExecution stepExecution = MetaDataInstanceFactory.createStepExecution("changeSleeperStatusStep",10L);
        return stepExecution;
    }
    @Test
    void sleeperAccountReader() throws Exception {
        itemReader.open(stepExecution.getExecutionContext());
        assertNotNull(itemReader.read());
    }



    @Test
    void sleeperAccountProcessor() {
    }

    @Test
    void sleeperAccountWriter() {
    }
}