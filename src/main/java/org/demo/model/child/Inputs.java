
package org.demo.model.child;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inputs {

    @JsonProperty("deal")
    private String deal;
    @JsonProperty("TaskName")
    private String taskName;
    @JsonProperty("NodeName")
    private String nodeName;
    @JsonProperty("Skippable")
    private String skippable;
    @JsonProperty("ActorId")
    private String actorId;
    @JsonProperty("traveller")
    private Traveller traveller;
    
}
