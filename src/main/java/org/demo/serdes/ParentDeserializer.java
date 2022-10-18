package org.demo.serdes;

import org.apache.kafka.common.serialization.Deserializer;
import org.demo.model.parent.Parent;
import org.jboss.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ParentDeserializer implements Deserializer<Parent> {

    Logger log = Logger.getLogger(ParentDeserializer.class, "kpalmab");
    
    private ObjectMapper objectMapper = new ObjectMapper();
    
    @Override
    public Parent deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(new String(data, "UTF-8"), Parent.class);
        } catch (Exception e) {
            log.error("Unable to deserialize parent message {} {}", data, e);
            return null;
        }
    }
}
