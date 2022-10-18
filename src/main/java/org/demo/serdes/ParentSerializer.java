package org.demo.serdes;

import javax.inject.Inject;

import org.apache.kafka.common.serialization.Serializer;
import org.demo.model.parent.Parent;
import org.jboss.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.arc.log.LoggerName;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ParentSerializer implements Serializer<Parent> {

    @Inject
    @LoggerName("kpalmab")
    Logger log;
    
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, Parent data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            log.error("Unable to serialize parent object {} {}", data, e);
            return null;
        }
    }
    
}
