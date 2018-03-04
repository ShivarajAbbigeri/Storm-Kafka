/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.experimenttopology;





import java.util.Map;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;

import org.apache.storm.topology.OutputFieldsDeclarer;

import org.apache.storm.tuple.Tuple;

/**
 *
 * @author admin
 */
public class WriteToKafka implements IRichBolt {
    private OutputCollector collector;
     //Assign topicName to string variable
      String topicName;
      Producer<String, String> producer;
      
      // create instance for properties to access producer configs   
      Properties props = new Properties();

    @Override
    public void prepare(Map map, TopologyContext tc, OutputCollector oc) {
        this.collector = oc;
        this.topicName = "wordsoutput";
        props.put("bootstrap.servers", "localhost:9092");
      
      //Set acknowledgements for producer requests.      
      props.put("acks", "all");
      
      //If the request fails, the producer can automatically retry,
      props.put("retries", 0);
      
      //Specify buffer size in config
      props.put("batch.size", 16384);
      
      //Reduce the no of requests less than 0   
      props.put("linger.ms", 1);
      
      //The buffer.memory controls the total amount of memory available to the producer for buffering.   
      props.put("buffer.memory", 33554432);
      
      props.put("key.serializer", 
         "org.apache.kafka.common.serialization.StringSerializer");
         
      props.put("value.serializer", 
         "org.apache.kafka.common.serialization.StringSerializer");
      producer = new KafkaProducer<String, String>(props);
    }

    @Override
    public void execute(Tuple tuple) {
        String w=tuple.getString(0);
        int i=tuple.getInteger(1);
        producer.send(new ProducerRecord<String, String>(topicName, w+": "+ Integer.toString(i)));
    }

    @Override
    public void cleanup() {
        
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer ofd) {
    
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
    return null;
    }
          
}
