package org.demo.serdes;

import java.io.IOException;

import org.demo.model.update.VariableValue;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class VariableValueDeserializer extends StdDeserializer<VariableValue> {
    public VariableValueDeserializer() { 
        this(null); 
    } 

    public VariableValueDeserializer(Class<?> vc) { 
        super(vc); 
    }

    @Override
    public VariableValue deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        if (node.has("firstName")) {
            String firstName = node.get("firstName").asText();
            String lastName = node.get("lastName").asText();
            String email = node.get("email").asText();
            String nationality = node.get("nationality").asText();
            JsonNode address = node.get("address");
            String street = address.get("street").asText();
            String city = address.get("city").asText();
            String zipCode = address.get("zipCode").asText();
            String country = address.get("country").asText();

            return new VariableValue(null, firstName, lastName, email, nationality, new org.demo.model.update.Address(street, city, zipCode, country));
        }
        return new VariableValue(node.asText());
    }
}
