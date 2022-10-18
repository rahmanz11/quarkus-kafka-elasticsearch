package org.demo.serdes;

import org.apache.kafka.common.serialization.Serializer;
import org.demo.model.child.Child;
import org.jboss.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ChildSerializer implements Serializer<Child> {

    Logger log = Logger.getLogger(ChildSerializer.class, "kpalmab");
    
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, Child data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            log.error("Unable to serialize child object {}", data, e);
            return null;
        }
    }
    
}
