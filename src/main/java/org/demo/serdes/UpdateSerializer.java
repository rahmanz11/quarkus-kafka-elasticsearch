package org.demo.serdes;

import org.apache.kafka.common.serialization.Serializer;
import org.demo.model.update.Update;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UpdateSerializer implements Serializer<Update> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, Update data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            System.err.printf("Unable to serialize update object {}", data, e);
            return null;
        }
    }
    
}
