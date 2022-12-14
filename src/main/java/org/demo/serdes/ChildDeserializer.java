package org.demo.serdes;

import org.apache.kafka.common.serialization.Deserializer;
import org.demo.model.child.Child;
import org.jboss.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChildDeserializer implements Deserializer<Child> {

    Logger log = Logger.getLogger(ChildDeserializer.class, "kpalmab");
    
    private ObjectMapper objectMapper = new ObjectMapper();
    
    @Override
    public Child deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(new String(data, "UTF-8"), Child.class);
        } catch (Exception e) {
            log.error("Unable to deserialize child message {}", data, e);
            return null;
        }
    }
}
