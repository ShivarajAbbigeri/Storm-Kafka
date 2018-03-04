/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.experimenttopology;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
public class CountBolt implements IRichBolt{
   Map<String, Integer> counters;
   private OutputCollector collector;
   
   @Override
   public void prepare(Map stormConf, TopologyContext context,
   OutputCollector collector) {
      this.counters = new HashMap<String, Integer>();
      this.collector = collector;
   }

   @Override
   public void execute(Tuple input) {
      String str = input.getString(0);
      
      if(!counters.containsKey(str)){
         counters.put(str, 1);
      }else {
         Integer c = counters.get(str) +1;
         counters.put(str, c);
      }
    String word=str;
    int count=counters.get(str);
    collector.emit(new Values(word,count));
      collector.ack(input);
   }

   @Override
   public void cleanup() {
      PrintWriter pw=null;
        try {
            
            pw = new PrintWriter("exp.txt");
      for(Map.Entry<String, Integer> entry:counters.entrySet()){
         
         
              System.out.println(entry.getKey()+" : " + entry.getValue());
              
              pw.append(entry.getKey()+" : " + entry.getValue());
              pw.println("\n");
          
          }
      } catch (FileNotFoundException ex) {
              Logger.getLogger(CountBolt.class.getName()).log(Level.SEVERE, null, ex);
          } finally {
              pw.close();
        }
   }

   @Override
   public void declareOutputFields(OutputFieldsDeclarer declarer) {
     declarer.declare(new Fields("word","count"));
   }

  
   public Map<String, Object> getComponentConfiguration() {
      return null;
   }
}