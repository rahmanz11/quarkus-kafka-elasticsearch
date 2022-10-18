
package org.demo.model.parent;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Parent {

    @JsonProperty("id")
    private String id;
    @JsonProperty("source")
    private String source;
    @JsonProperty("type")
    private String type;
    @JsonProperty("time")
    private String time;
    @JsonProperty("data")
    private Data data;
    @JsonProperty("specversion")
    private String specversion;
    @JsonProperty("kogitoprocinstanceid")
    private String kogitoprocinstanceid;
    @JsonProperty("kogitoprocid")
    private String kogitoprocid;
    @JsonProperty("kogitoaddons")
    private String kogitoaddons;
    @JsonProperty("kogitousertaskist")
    private String kogitousertaskist;
    
}
