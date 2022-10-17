
package org.demo.model.update;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
    "variableName",
    "variableValue",
    "variablePreviousValue",
    "changeDate",
    "changedByNodeId",
    "changedByNodeName",
    "changedByNodeType",
    "changedByUser",
    "processInstanceId",
    "rootProcessInstanceId",
    "processId",
    "rootProcessId"
})
@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("variableName")
    private String variableName;
    @JsonProperty("variableValue")
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("variableName")
    public String getVariableName() {
        return variableName;
    }

    @JsonProperty("variableName")
    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    @JsonProperty("variableValue")
    public VariableValue getVariableValue() {
        return variableValue;
    }

    @JsonProperty("variableValue")
    public void setVariableValue(VariableValue variableValue) {
        this.variableValue = variableValue;
    }

    @JsonProperty("variablePreviousValue")
    public Object getVariablePreviousValue() {
        return variablePreviousValue;
    }

    @JsonProperty("variablePreviousValue")
    public void setVariablePreviousValue(Object variablePreviousValue) {
        this.variablePreviousValue = variablePreviousValue;
    }

    @JsonProperty("changeDate")
    public String getChangeDate() {
        return changeDate;
    }

    @JsonProperty("changeDate")
    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }

    @JsonProperty("changedByNodeId")
    public Object getChangedByNodeId() {
        return changedByNodeId;
    }

    @JsonProperty("changedByNodeId")
    public void setChangedByNodeId(Object changedByNodeId) {
        this.changedByNodeId = changedByNodeId;
    }

    @JsonProperty("changedByNodeName")
    public Object getChangedByNodeName() {
        return changedByNodeName;
    }

    @JsonProperty("changedByNodeName")
    public void setChangedByNodeName(Object changedByNodeName) {
        this.changedByNodeName = changedByNodeName;
    }

    @JsonProperty("changedByNodeType")
    public Object getChangedByNodeType() {
        return changedByNodeType;
    }

    @JsonProperty("changedByNodeType")
    public void setChangedByNodeType(Object changedByNodeType) {
        this.changedByNodeType = changedByNodeType;
    }

    @JsonProperty("changedByUser")
    public Object getChangedByUser() {
        return changedByUser;
    }

    @JsonProperty("changedByUser")
    public void setChangedByUser(Object changedByUser) {
        this.changedByUser = changedByUser;
    }

    @JsonProperty("processInstanceId")
    public String getProcessInstanceId() {
        return processInstanceId;
    }

    @JsonProperty("processInstanceId")
    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    @JsonProperty("rootProcessInstanceId")
    public Object getRootProcessInstanceId() {
        return rootProcessInstanceId;
    }

    @JsonProperty("rootProcessInstanceId")
    public void setRootProcessInstanceId(Object rootProcessInstanceId) {
        this.rootProcessInstanceId = rootProcessInstanceId;
    }

    @JsonProperty("processId")
    public String getProcessId() {
        return processId;
    }

    @JsonProperty("processId")
    public void setProcessId(String processId) {
        this.processId = processId;
    }

    @JsonProperty("rootProcessId")
    public Object getRootProcessId() {
        return rootProcessId;
    }

    @JsonProperty("rootProcessId")
    public void setRootProcessId(Object rootProcessId) {
        this.rootProcessId = rootProcessId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Data.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("variableName");
        sb.append('=');
        sb.append(((this.variableName == null)?"<null>":this.variableName));
        sb.append(',');
        sb.append("variableValue");
        sb.append('=');
        sb.append(((this.variableValue == null)?"<null>":this.variableValue));
        sb.append(',');
        sb.append("variablePreviousValue");
        sb.append('=');
        sb.append(((this.variablePreviousValue == null)?"<null>":this.variablePreviousValue));
        sb.append(',');
        sb.append("changeDate");
        sb.append('=');
        sb.append(((this.changeDate == null)?"<null>":this.changeDate));
        sb.append(',');
        sb.append("changedByNodeId");
        sb.append('=');
        sb.append(((this.changedByNodeId == null)?"<null>":this.changedByNodeId));
        sb.append(',');
        sb.append("changedByNodeName");
        sb.append('=');
        sb.append(((this.changedByNodeName == null)?"<null>":this.changedByNodeName));
        sb.append(',');
        sb.append("changedByNodeType");
        sb.append('=');
        sb.append(((this.changedByNodeType == null)?"<null>":this.changedByNodeType));
        sb.append(',');
        sb.append("changedByUser");
        sb.append('=');
        sb.append(((this.changedByUser == null)?"<null>":this.changedByUser));
        sb.append(',');
        sb.append("processInstanceId");
        sb.append('=');
        sb.append(((this.processInstanceId == null)?"<null>":this.processInstanceId));
        sb.append(',');
        sb.append("rootProcessInstanceId");
        sb.append('=');
        sb.append(((this.rootProcessInstanceId == null)?"<null>":this.rootProcessInstanceId));
        sb.append(',');
        sb.append("processId");
        sb.append('=');
        sb.append(((this.processId == null)?"<null>":this.processId));
        sb.append(',');
        sb.append("rootProcessId");
        sb.append('=');
        sb.append(((this.rootProcessId == null)?"<null>":this.rootProcessId));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.processInstanceId == null)? 0 :this.processInstanceId.hashCode()));
        result = ((result* 31)+((this.variableName == null)? 0 :this.variableName.hashCode()));
        result = ((result* 31)+((this.changedByNodeId == null)? 0 :this.changedByNodeId.hashCode()));
        result = ((result* 31)+((this.variableValue == null)? 0 :this.variableValue.hashCode()));
        result = ((result* 31)+((this.rootProcessId == null)? 0 :this.rootProcessId.hashCode()));
        result = ((result* 31)+((this.changedByNodeName == null)? 0 :this.changedByNodeName.hashCode()));
        result = ((result* 31)+((this.processId == null)? 0 :this.processId.hashCode()));
        result = ((result* 31)+((this.changeDate == null)? 0 :this.changeDate.hashCode()));
        result = ((result* 31)+((this.variablePreviousValue == null)? 0 :this.variablePreviousValue.hashCode()));
        result = ((result* 31)+((this.changedByUser == null)? 0 :this.changedByUser.hashCode()));
        result = ((result* 31)+((this.rootProcessInstanceId == null)? 0 :this.rootProcessInstanceId.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.changedByNodeType == null)? 0 :this.changedByNodeType.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Data) == false) {
            return false;
        }
        Data rhs = ((Data) other);
        return ((((((((((((((this.processInstanceId == rhs.processInstanceId)||((this.processInstanceId!= null)&&this.processInstanceId.equals(rhs.processInstanceId)))&&((this.variableName == rhs.variableName)||((this.variableName!= null)&&this.variableName.equals(rhs.variableName))))&&((this.changedByNodeId == rhs.changedByNodeId)||((this.changedByNodeId!= null)&&this.changedByNodeId.equals(rhs.changedByNodeId))))&&((this.variableValue == rhs.variableValue)||((this.variableValue!= null)&&this.variableValue.equals(rhs.variableValue))))&&((this.rootProcessId == rhs.rootProcessId)||((this.rootProcessId!= null)&&this.rootProcessId.equals(rhs.rootProcessId))))&&((this.changedByNodeName == rhs.changedByNodeName)||((this.changedByNodeName!= null)&&this.changedByNodeName.equals(rhs.changedByNodeName))))&&((this.processId == rhs.processId)||((this.processId!= null)&&this.processId.equals(rhs.processId))))&&((this.changeDate == rhs.changeDate)||((this.changeDate!= null)&&this.changeDate.equals(rhs.changeDate))))&&((this.variablePreviousValue == rhs.variablePreviousValue)||((this.variablePreviousValue!= null)&&this.variablePreviousValue.equals(rhs.variablePreviousValue))))&&((this.changedByUser == rhs.changedByUser)||((this.changedByUser!= null)&&this.changedByUser.equals(rhs.changedByUser))))&&((this.rootProcessInstanceId == rhs.rootProcessInstanceId)||((this.rootProcessInstanceId!= null)&&this.rootProcessInstanceId.equals(rhs.rootProcessInstanceId))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.changedByNodeType == rhs.changedByNodeType)||((this.changedByNodeType!= null)&&this.changedByNodeType.equals(rhs.changedByNodeType))));
    }

}
