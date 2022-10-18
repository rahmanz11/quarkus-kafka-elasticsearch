package org.demo.serdes;

import java.io.IOException;

import org.demo.model.update.VariableValue;
import org.jboss.logging.Logger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class VariableValueDeserializer extends StdDeserializer<VariableValue> {

    Logger log = Logger.getLogger(VariableValueDeserializer.class, "kpalmab");
    
    public VariableValueDeserializer() { 
        this(null); 
    } 

    public VariableValueDeserializer(Class<?> vc) { 
        super(vc); 
    }

    @Override
    public VariableValue deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {
        try {
            JsonNode node = jp.getCodec().readTree(jp);
            if (node.has("firstName")) {
                String firstName = node.get("firstName").asText(null);
                String lastName = node.get("lastName").asText(null);
                String email = node.get("email").asText(null);
                String nationality = node.get("nationality").asText(null);
                String street = node.get("address").path("street").asText(null);
                String city = node.get("address").path("city").asText(null);
                String zipCode = node.get("address").path("zipCode").asText(null);
                String country = node.get("address").path("country").asText(null);
    
                return new VariableValue(null, firstName, lastName, email, nationality, new org.demo.model.update.Address(street, city, zipCode, country));
            } else {
                String text = node.textValue();
                return new VariableValue(null, text.toString(), null, null, null, null);
            }
        } catch (Exception e) {
            log.error("Unable to deserialize update->data->variableValue object ", e);
        }
        return null;
    }
}
