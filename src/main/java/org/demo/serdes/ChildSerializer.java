package org.demo.serdes;

import javax.inject.Inject;

import org.apache.kafka.common.serialization.Serializer;
import org.demo.model.child.Child;
import org.jboss.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.arc.log.LoggerName;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ChildSerializer implements Serializer<Child> {

    @Inject
    @LoggerName("kpalmab")
    Logger log;
    
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
