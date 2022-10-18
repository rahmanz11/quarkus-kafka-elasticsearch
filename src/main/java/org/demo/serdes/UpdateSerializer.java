package org.demo.serdes;

import org.apache.kafka.common.serialization.Serializer;
import org.demo.model.update.Update;
import org.jboss.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UpdateSerializer implements Serializer<Update> {

    Logger log = Logger.getLogger(UpdateSerializer.class, "kpalmab");
    
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, Update data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            log.error("Unable to serialize update object {}", data, e);
            return null;
        }
    }
    
}
