package com.codefarm;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class EventProducer {
//1. configs - broker, serializer(key, value)
    boolean sendEvent(String message){
        Properties kafkaProducerConfig = new Properties();

        kafkaProducerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        kafkaProducerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        kafkaProducerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
//2. record
        ProducerRecord<String,String>record = new ProducerRecord<>("my-first-topic",message);//topic is the place in 2.13 to show the result
//3. Producer Interface
        KafkaProducer<String,String>producer = new KafkaProducer<String, String>(kafkaProducerConfig);
//4. send the record to cluster

        producer.send(record);
        //5. flush/close
        producer.flush();
        producer.close();
     return true;
    }
}
