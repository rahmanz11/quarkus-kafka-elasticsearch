
package org.demo.model.update;

import org.demo.serdes.VariableValueDeserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Data {

    @JsonProperty("variableName")
    private String variableName;
    @JsonProperty("variableValue")
    @JsonDeserialize(using = VariableValueDeserializer.class)
    private VariableValue variableValue;
    @JsonProperty("variablePreviousValue")
    private Object variablePreviousValue;
    @JsonProperty("changeDate")
    private String changeDate;
    @JsonProperty("changedByNodeId")
    private Object changedByNodeId;
    @JsonProperty("changedByNodeName")
    private Object changedByNodeName;
    @JsonProperty("changedByNodeType")
    private Object changedByNodeType;
    @JsonProperty("changedByUser")
    private Object changedByUser;
    @JsonProperty("processInstanceId")
    private String processInstanceId;
    @JsonProperty("rootProcessInstanceId")
    private Object rootProcessInstanceId;
    @JsonProperty("processId")
    private String processId;
    @JsonProperty("rootProcessId")
    private Object rootProcessId;
}
