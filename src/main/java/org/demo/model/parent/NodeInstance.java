
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
public class NodeInstance {

    @JsonProperty("id")
    private String id;
    @JsonProperty("nodeId")
    private String nodeId;
    @JsonProperty("nodeDefinitionId")
    private String nodeDefinitionId;
    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("nodeType")
    private String nodeType;
    @JsonProperty("triggerTime")
    private String triggerTime;
    @JsonProperty("leaveTime")
    private String leaveTime;
   }
