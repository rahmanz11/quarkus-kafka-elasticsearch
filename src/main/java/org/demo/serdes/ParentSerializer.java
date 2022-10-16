package org.demo.serdes;

import org.apache.kafka.common.serialization.Serializer;
import org.demo.model.parent.Parent;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ParentSerializer implements Serializer<Parent> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, Parent data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            System.err.printf("Unable to serialize object {}", data, e);
            return null;
        }
    }
    
}
