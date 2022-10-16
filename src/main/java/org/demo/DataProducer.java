package org.demo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.apache.commons.text.StringEscapeUtils;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.runtime.StartupEvent;
import io.smallrye.reactive.messaging.kafka.Record;

@ApplicationScoped
public class DataProducer {
    
    @Inject
    @Channel("parent-out")
    Emitter<Record<String, String>> emitter;

    /**
     * Sends message to the "parent-out" channel
     * Messages are sent to the broker.
     * @throws IOException
     * @throws DatabindException
     * @throws StreamReadException
     * @throws URISyntaxException
     **/
    void onStart(@Observes StartupEvent ev) throws StreamReadException, DatabindException, IOException, URISyntaxException {
        
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String jsonString = readFile("parent-event.json", StandardCharsets.UTF_8);
        List<Object> parentData = objectMapper.readValue(jsonString, new TypeReference<List<Object>>(){});
        
        /*
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        Object[] parentData = objectMapper.readValue(
                new File(classloader.getResource("parent-event.json").getFile()),
                new TypeReference<Object[]>(){});
        */        
        parentData.forEach(obj -> {
            emitter.send(Record.of(UUID.randomUUID().toString(), StringEscapeUtils.escapeJson(obj.toString())))
                    .whenComplete((success, failure) -> {
                        if (failure != null) {
                            System.out.println("D'oh! " + failure.getMessage());
                        } else {
                            System.out.println("Message processed successfully");
                        }
                    });
        });
    }
    
    static String readFile(String path, Charset encoding) throws IOException, URISyntaxException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(path);
        byte[] encoded = is.readAllBytes();
        String escaped = StringEscapeUtils.escapeJson(new String(encoded, encoding));
        return escaped;
    }

    // @Incoming("parent-in")
    // @Blocking
    // public CompletionStage<Void> receive(Message<String> message) {
    //     System.out.println(message.getPayload());
    //     //return message.withPayload(message.getPayload().toUpperCase());
    //     return null;
    // }
    
}
