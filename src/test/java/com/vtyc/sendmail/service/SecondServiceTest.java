package com.vtyc.sendmail.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SecondServiceTest {

    @Autowired
    SecondService secondService;

    @Test
    public void JudgeToday() {
        System.out.println(secondService.JudgeToday());
    }
    @Test
    public void getWcMstrTotal(){
        System.out.println(secondService.getWcMstrTotal());
    }
    @Test
    public void getPtMstrTotal(){
        System.out.println(secondService.getPtMstrTotal());
    }
}