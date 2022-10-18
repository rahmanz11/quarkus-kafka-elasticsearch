
package org.demo.model.update;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Update {

    @JsonProperty("id")
    private String id;
    @JsonProperty("source")
    private String source;
    @JsonProperty("type")
    private String type;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("data")
    private Data data;
    @JsonProperty("kogitoVariableName")
    private String kogitoVariableName;
    @JsonProperty("specversion")
    private String specversion;
    @JsonProperty("kogitoprocinstanceid")
    private String kogitoprocinstanceid;
    @JsonProperty("kogitoprocid")
    private String kogitoprocid;
    @JsonProperty("kogitoaddons")
    private String kogitoaddons;
}
