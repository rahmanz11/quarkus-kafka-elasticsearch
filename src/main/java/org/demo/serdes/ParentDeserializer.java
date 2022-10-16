package org.demo.serdes;

import org.apache.kafka.common.serialization.Deserializer;
import org.demo.model.parent.Parent;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ParentDeserializer implements Deserializer<Parent> {

    private ObjectMapper objectMapper = new ObjectMapper();
    
    @Override
    public Parent deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(new String(data, "UTF-8"), Parent.class);
        } catch (Exception e) {
            System.err.printf("Unable to deserialize message {}", data, e);
            return null;
        }
    }
}
