
package org.demo.model.parent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "id",
    "parentInstanceId",
    "rootInstanceId",
    "processId",
    "rootProcessId",
    "processName",
    "startDate",
    "endDate",
    "state",
    "businessKey",
    "nodeInstances",
    "variables",
    "error",
    "roles",
    "milestones"
})
@Generated("jsonschema2pojo")
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("parentInstanceId")
    public Object getParentInstanceId() {
        return parentInstanceId;
    }

    @JsonProperty("parentInstanceId")
    public void setParentInstanceId(Object parentInstanceId) {
        this.parentInstanceId = parentInstanceId;
    }

    @JsonProperty("rootInstanceId")
    public Object getRootInstanceId() {
        return rootInstanceId;
    }

    @JsonProperty("rootInstanceId")
    public void setRootInstanceId(Object rootInstanceId) {
        this.rootInstanceId = rootInstanceId;
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

    @JsonProperty("processName")
    public String getProcessName() {
        return processName;
    }

    @JsonProperty("processName")
    public void setProcessName(String processName) {
        this.processName = processName;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("endDate")
    public Object getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(Object endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("state")
    public Integer getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(Integer state) {
        this.state = state;
    }

    @JsonProperty("businessKey")
    public Object getBusinessKey() {
        return businessKey;
    }

    @JsonProperty("businessKey")
    public void setBusinessKey(Object businessKey) {
        this.businessKey = businessKey;
    }

    @JsonProperty("nodeInstances")
    public List<NodeInstance> getNodeInstances() {
        return nodeInstances;
    }

    @JsonProperty("nodeInstances")
    public void setNodeInstances(List<NodeInstance> nodeInstances) {
        this.nodeInstances = nodeInstances;
    }

    @JsonProperty("variables")
    public Variables getVariables() {
        return variables;
    }

    @JsonProperty("variables")
    public void setVariables(Variables variables) {
        this.variables = variables;
    }

    @JsonProperty("error")
    public Object getError() {
        return error;
    }

    @JsonProperty("error")
    public void setError(Object error) {
        this.error = error;
    }

    @JsonProperty("roles")
    public Object getRoles() {
        return roles;
    }

    @JsonProperty("roles")
    public void setRoles(Object roles) {
        this.roles = roles;
    }

    @JsonProperty("milestones")
    public List<Object> getMilestones() {
        return milestones;
    }

    @JsonProperty("milestones")
    public void setMilestones(List<Object> milestones) {
        this.milestones = milestones;
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
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("parentInstanceId");
        sb.append('=');
        sb.append(((this.parentInstanceId == null)?"<null>":this.parentInstanceId));
        sb.append(',');
        sb.append("rootInstanceId");
        sb.append('=');
        sb.append(((this.rootInstanceId == null)?"<null>":this.rootInstanceId));
        sb.append(',');
        sb.append("processId");
        sb.append('=');
        sb.append(((this.processId == null)?"<null>":this.processId));
        sb.append(',');
        sb.append("rootProcessId");
        sb.append('=');
        sb.append(((this.rootProcessId == null)?"<null>":this.rootProcessId));
        sb.append(',');
        sb.append("processName");
        sb.append('=');
        sb.append(((this.processName == null)?"<null>":this.processName));
        sb.append(',');
        sb.append("startDate");
        sb.append('=');
        sb.append(((this.startDate == null)?"<null>":this.startDate));
        sb.append(',');
        sb.append("endDate");
        sb.append('=');
        sb.append(((this.endDate == null)?"<null>":this.endDate));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null)?"<null>":this.state));
        sb.append(',');
        sb.append("businessKey");
        sb.append('=');
        sb.append(((this.businessKey == null)?"<null>":this.businessKey));
        sb.append(',');
        sb.append("nodeInstances");
        sb.append('=');
        sb.append(((this.nodeInstances == null)?"<null>":this.nodeInstances));
        sb.append(',');
        sb.append("variables");
        sb.append('=');
        sb.append(((this.variables == null)?"<null>":this.variables));
        sb.append(',');
        sb.append("error");
        sb.append('=');
        sb.append(((this.error == null)?"<null>":this.error));
        sb.append(',');
        sb.append("roles");
        sb.append('=');
        sb.append(((this.roles == null)?"<null>":this.roles));
        sb.append(',');
        sb.append("milestones");
        sb.append('=');
        sb.append(((this.milestones == null)?"<null>":this.milestones));
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
        result = ((result* 31)+((this.rootInstanceId == null)? 0 :this.rootInstanceId.hashCode()));
        result = ((result* 31)+((this.variables == null)? 0 :this.variables.hashCode()));
        result = ((result* 31)+((this.endDate == null)? 0 :this.endDate.hashCode()));
        result = ((result* 31)+((this.roles == null)? 0 :this.roles.hashCode()));
        result = ((result* 31)+((this.rootProcessId == null)? 0 :this.rootProcessId.hashCode()));
        result = ((result* 31)+((this.error == null)? 0 :this.error.hashCode()));
        result = ((result* 31)+((this.nodeInstances == null)? 0 :this.nodeInstances.hashCode()));
        result = ((result* 31)+((this.parentInstanceId == null)? 0 :this.parentInstanceId.hashCode()));
        result = ((result* 31)+((this.processId == null)? 0 :this.processId.hashCode()));
        result = ((result* 31)+((this.processName == null)? 0 :this.processName.hashCode()));
        result = ((result* 31)+((this.businessKey == null)? 0 :this.businessKey.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.state == null)? 0 :this.state.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.milestones == null)? 0 :this.milestones.hashCode()));
        result = ((result* 31)+((this.startDate == null)? 0 :this.startDate.hashCode()));
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
        return (((((((((((((((((this.rootInstanceId == rhs.rootInstanceId)||((this.rootInstanceId!= null)&&this.rootInstanceId.equals(rhs.rootInstanceId)))&&((this.variables == rhs.variables)||((this.variables!= null)&&this.variables.equals(rhs.variables))))&&((this.endDate == rhs.endDate)||((this.endDate!= null)&&this.endDate.equals(rhs.endDate))))&&((this.roles == rhs.roles)||((this.roles!= null)&&this.roles.equals(rhs.roles))))&&((this.rootProcessId == rhs.rootProcessId)||((this.rootProcessId!= null)&&this.rootProcessId.equals(rhs.rootProcessId))))&&((this.error == rhs.error)||((this.error!= null)&&this.error.equals(rhs.error))))&&((this.nodeInstances == rhs.nodeInstances)||((this.nodeInstances!= null)&&this.nodeInstances.equals(rhs.nodeInstances))))&&((this.parentInstanceId == rhs.parentInstanceId)||((this.parentInstanceId!= null)&&this.parentInstanceId.equals(rhs.parentInstanceId))))&&((this.processId == rhs.processId)||((this.processId!= null)&&this.processId.equals(rhs.processId))))&&((this.processName == rhs.processName)||((this.processName!= null)&&this.processName.equals(rhs.processName))))&&((this.businessKey == rhs.businessKey)||((this.businessKey!= null)&&this.businessKey.equals(rhs.businessKey))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.state == rhs.state)||((this.state!= null)&&this.state.equals(rhs.state))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.milestones == rhs.milestones)||((this.milestones!= null)&&this.milestones.equals(rhs.milestones))))&&((this.startDate == rhs.startDate)||((this.startDate!= null)&&this.startDate.equals(rhs.startDate))));
    }

}
