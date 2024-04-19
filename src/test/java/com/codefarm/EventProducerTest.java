package com.codefarm;

import org.junit.jupiter.api.Test;

public class EventProducerTest {

    EventProducer eventProducer= new EventProducer();

    @Test
    void sendEventTest(){
        eventProducer.sendEvent("123 My first event sss");


    }
}
