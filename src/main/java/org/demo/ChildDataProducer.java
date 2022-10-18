package org.demo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.demo.model.child.Child;
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

import io.quarkus.runtime.StartupEvent;
import io.smallrye.reactive.messaging.kafka.Record;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApplicationScoped
@Getter
@Setter
@NoArgsConstructor
public class ChildDataProducer {

    // Logger log = Logger.getLogger(ChildDataProducer.class, "kpalmab");
    
    // @Inject
    // @Channel("child-out")
    // @OnOverflow(value = Strategy.UNBOUNDED_BUFFER)
    // Emitter<Record<String, Child>> emitter;

    // /**
    //  * Sends message to the "child-out" channel
    //  * Messages are sent to the broker.
    //  * @throws IOException
    //  * @throws DatabindException
    //  * @throws StreamReadException
    //  * @throws URISyntaxException
    //  **/
    // void onStart(@Observes StartupEvent ev) throws StreamReadException, DatabindException, IOException, URISyntaxException {
        
    //     final ObjectMapper objectMapper = new ObjectMapper();
    //     objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    //     objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
    //     objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
    //     ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        
    //     List<Child> childData = objectMapper.readValue(classloader.getResourceAsStream("data/child-event.json"), new TypeReference<List<Child>>(){});
    //     childData.forEach(data -> {
    //         try {
    //             emitter.send(Record.of(UUID.randomUUID().toString(), data))
    //             .whenComplete((success, failure) -> {
    //                 if (failure != null) {
    //                     System.out.println("D'oh! " + failure.getMessage());
    //                 }
    //             });
    //         } catch (Exception e) {
    //             log.error("Exception in publish parent data {} ", e);
    //         }
    //     });
    // }   
}
