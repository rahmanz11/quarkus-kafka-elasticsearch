package org.demo.serdes;

import org.apache.kafka.common.serialization.Deserializer;
import org.demo.model.update.Update;
import org.jboss.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateDeserializer implements Deserializer<Update> {
    
    Logger log = Logger.getLogger(UpdateDeserializer.class, "kpalmab");
    
    private ObjectMapper objectMapper = new ObjectMapper();
    
    @Override
    public Update deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(new String(data, "UTF-8"), Update.class);
        } catch (Exception e) {
            log.error("Unable to deserialize update message {} {}", data, e);
            return null;
        }
    }
}
