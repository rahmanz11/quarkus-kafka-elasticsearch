
package org.demo.model.parent;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Data {

    @JsonProperty("id")
    private String id;
    @JsonProperty("parentInstanceId")
    private Object parentInstanceId;
    @JsonProperty("rootInstanceId")
    private Object rootInstanceId;
    @JsonProperty("processId")
    private String processId;
    @JsonProperty("rootProcessId")
    private Object rootProcessId;
    @JsonProperty("processName")
    private String processName;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private Object endDate;
    @JsonProperty("state")
    private Integer state;
    @JsonProperty("businessKey")
    private Object businessKey;
    @JsonProperty("nodeInstances")
    private List<NodeInstance> nodeInstances = new ArrayList<NodeInstance>();
    @JsonProperty("variables")
    private Variables variables;
    @JsonProperty("error")
    private Object error;
    @JsonProperty("roles")
    private Object roles;
    @JsonProperty("milestones")
    private List<Object> milestones = new ArrayList<Object>();
}
