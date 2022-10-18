package org.demo.serdes;

import javax.inject.Inject;

import org.apache.kafka.common.serialization.Deserializer;
import org.demo.model.update.Update;
import org.jboss.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.arc.log.LoggerName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateDeserializer implements Deserializer<Update> {
    
    @Inject
    @LoggerName("kpalmab")
    Logger log;
    
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
