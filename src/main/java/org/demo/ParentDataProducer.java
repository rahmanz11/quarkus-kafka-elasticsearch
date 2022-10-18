package org.demo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.demo.model.parent.Parent;
import org.demo.model.update.Update;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.OnOverflow;
import org.eclipse.microprofile.reactive.messaging.OnOverflow.Strategy;
import org.jboss.logging.Logger;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.arc.log.LoggerName;
import io.quarkus.runtime.StartupEvent;
import io.smallrye.reactive.messaging.kafka.Record;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApplicationScoped
@Getter
@Setter
@NoArgsConstructor
public class ParentDataProducer {
    
    @Inject
    @LoggerName("kpalmab")
    Logger log;
    
    @Inject
    @Channel("parent-out")
    @OnOverflow(value = Strategy.UNBOUNDED_BUFFER)
    Emitter<Record<String, Parent>> parentEmitter;

    @Inject
    @Channel("update-out")
    @OnOverflow(value = Strategy.UNBOUNDED_BUFFER)
    Emitter<Record<String, Update>> updateEmitter;

    private ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    private ClassLoader getClassLoader() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return classloader;
    }

    /**
     * Sends message to the "parent-out" and "update-out" channel
     * Messages are sent to the broker.
     * @throws IOException
     * @throws DatabindException
     * @throws StreamReadException
     * @throws URISyntaxException
     **/
    void onStart(@Observes StartupEvent ev) throws StreamReadException, DatabindException, IOException, URISyntaxException {
                
        List<Parent> parentData = getObjectMapper().readValue(getClassLoader().getResourceAsStream("data/parent-event.json"), new TypeReference<List<Parent>>(){});
        parentData.forEach(data -> {
            try {
                parentEmitter.send(Record.of(UUID.randomUUID().toString(), data))
                .whenComplete((success, failure) -> {
                    if (failure != null) {
                        log.error("Failed to publish parent data {} ", failure);
                    }
                });
            } catch (Exception e) {
                log.error("Exception in publish parent data {} ", e);
            }
        });

        List<Update> updateData = getObjectMapper().readValue(getClassLoader().getResourceAsStream("data/update-event.json"), new TypeReference<List<Update>>(){});
        updateData.forEach(data -> {
            try {
                updateEmitter.send(Record.of(UUID.randomUUID().toString(), data))
                .whenComplete((success, failure) -> {
                    if (failure != null) {
                        log.error("Failed to publish update data {} ", failure);
                    }
                });
            } catch (Exception e) {
                log.error("Exception in publish update data {} ", e);
            }
        });
    }   
}
