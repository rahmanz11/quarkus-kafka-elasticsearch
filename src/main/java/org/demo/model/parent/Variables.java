
package org.demo.model.parent;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Variables {

    @JsonProperty("deal")
    private String deal;
    @JsonProperty("traveller")
    private Traveller traveller;
    @JsonProperty("review")
    private String review;
}
