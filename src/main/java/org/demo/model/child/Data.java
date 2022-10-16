
package org.demo.model.child;

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
    "taskName",
    "taskDescription",
    "taskPriority",
    "referenceName",
    "startDate",
    "completeDate",
    "state",
    "actualOwner",
    "potentialUsers",
    "potentialGroups",
    "excludedUsers",
    "adminUsers",
    "adminGroups",
    "inputs",
    "outputs",
    "comments",
    "attachments",
    "processInstanceId",
    "rootProcessInstanceId",
    "processId",
    "rootProcessId"
})
@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("id")
    private String id;
    @JsonProperty("taskName")
    private String taskName;
    @JsonProperty("taskDescription")
    private Object taskDescription;
    @JsonProperty("taskPriority")
    private Object taskPriority;
    @JsonProperty("referenceName")
    private String referenceName;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("completeDate")
    private Object completeDate;
    @JsonProperty("state")
    private String state;
    @JsonProperty("actualOwner")
    private Object actualOwner;
    @JsonProperty("potentialUsers")
    private List<String> potentialUsers = new ArrayList<String>();
    @JsonProperty("potentialGroups")
    private List<Object> potentialGroups = new ArrayList<Object>();
    @JsonProperty("excludedUsers")
    private List<Object> excludedUsers = new ArrayList<Object>();
    @JsonProperty("adminUsers")
    private List<Object> adminUsers = new ArrayList<Object>();
    @JsonProperty("adminGroups")
    private List<Object> adminGroups = new ArrayList<Object>();
    @JsonProperty("inputs")
    private Inputs inputs;
    @JsonProperty("outputs")
    private Outputs outputs;
    @JsonProperty("comments")
    private List<Object> comments = new ArrayList<Object>();
    @JsonProperty("attachments")
    private List<Object> attachments = new ArrayList<Object>();
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

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("taskName")
    public String getTaskName() {
        return taskName;
    }

    @JsonProperty("taskName")
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @JsonProperty("taskDescription")
    public Object getTaskDescription() {
        return taskDescription;
    }

    @JsonProperty("taskDescription")
    public void setTaskDescription(Object taskDescription) {
        this.taskDescription = taskDescription;
    }

    @JsonProperty("taskPriority")
    public Object getTaskPriority() {
        return taskPriority;
    }

    @JsonProperty("taskPriority")
    public void setTaskPriority(Object taskPriority) {
        this.taskPriority = taskPriority;
    }

    @JsonProperty("referenceName")
    public String getReferenceName() {
        return referenceName;
    }

    @JsonProperty("referenceName")
    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("completeDate")
    public Object getCompleteDate() {
        return completeDate;
    }

    @JsonProperty("completeDate")
    public void setCompleteDate(Object completeDate) {
        this.completeDate = completeDate;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("actualOwner")
    public Object getActualOwner() {
        return actualOwner;
    }

    @JsonProperty("actualOwner")
    public void setActualOwner(Object actualOwner) {
        this.actualOwner = actualOwner;
    }

    @JsonProperty("potentialUsers")
    public List<String> getPotentialUsers() {
        return potentialUsers;
    }

    @JsonProperty("potentialUsers")
    public void setPotentialUsers(List<String> potentialUsers) {
        this.potentialUsers = potentialUsers;
    }

    @JsonProperty("potentialGroups")
    public List<Object> getPotentialGroups() {
        return potentialGroups;
    }

    @JsonProperty("potentialGroups")
    public void setPotentialGroups(List<Object> potentialGroups) {
        this.potentialGroups = potentialGroups;
    }

    @JsonProperty("excludedUsers")
    public List<Object> getExcludedUsers() {
        return excludedUsers;
    }

    @JsonProperty("excludedUsers")
    public void setExcludedUsers(List<Object> excludedUsers) {
        this.excludedUsers = excludedUsers;
    }

    @JsonProperty("adminUsers")
    public List<Object> getAdminUsers() {
        return adminUsers;
    }

    @JsonProperty("adminUsers")
    public void setAdminUsers(List<Object> adminUsers) {
        this.adminUsers = adminUsers;
    }

    @JsonProperty("adminGroups")
    public List<Object> getAdminGroups() {
        return adminGroups;
    }

    @JsonProperty("adminGroups")
    public void setAdminGroups(List<Object> adminGroups) {
        this.adminGroups = adminGroups;
    }

    @JsonProperty("inputs")
    public Inputs getInputs() {
        return inputs;
    }

    @JsonProperty("inputs")
    public void setInputs(Inputs inputs) {
        this.inputs = inputs;
    }

    @JsonProperty("outputs")
    public Outputs getOutputs() {
        return outputs;
    }

    @JsonProperty("outputs")
    public void setOutputs(Outputs outputs) {
        this.outputs = outputs;
    }

    @JsonProperty("comments")
    public List<Object> getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(List<Object> comments) {
        this.comments = comments;
    }

    @JsonProperty("attachments")
    public List<Object> getAttachments() {
        return attachments;
    }

    @JsonProperty("attachments")
    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
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
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("taskName");
        sb.append('=');
        sb.append(((this.taskName == null)?"<null>":this.taskName));
        sb.append(',');
        sb.append("taskDescription");
        sb.append('=');
        sb.append(((this.taskDescription == null)?"<null>":this.taskDescription));
        sb.append(',');
        sb.append("taskPriority");
        sb.append('=');
        sb.append(((this.taskPriority == null)?"<null>":this.taskPriority));
        sb.append(',');
        sb.append("referenceName");
        sb.append('=');
        sb.append(((this.referenceName == null)?"<null>":this.referenceName));
        sb.append(',');
        sb.append("startDate");
        sb.append('=');
        sb.append(((this.startDate == null)?"<null>":this.startDate));
        sb.append(',');
        sb.append("completeDate");
        sb.append('=');
        sb.append(((this.completeDate == null)?"<null>":this.completeDate));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null)?"<null>":this.state));
        sb.append(',');
        sb.append("actualOwner");
        sb.append('=');
        sb.append(((this.actualOwner == null)?"<null>":this.actualOwner));
        sb.append(',');
        sb.append("potentialUsers");
        sb.append('=');
        sb.append(((this.potentialUsers == null)?"<null>":this.potentialUsers));
        sb.append(',');
        sb.append("potentialGroups");
        sb.append('=');
        sb.append(((this.potentialGroups == null)?"<null>":this.potentialGroups));
        sb.append(',');
        sb.append("excludedUsers");
        sb.append('=');
        sb.append(((this.excludedUsers == null)?"<null>":this.excludedUsers));
        sb.append(',');
        sb.append("adminUsers");
        sb.append('=');
        sb.append(((this.adminUsers == null)?"<null>":this.adminUsers));
        sb.append(',');
        sb.append("adminGroups");
        sb.append('=');
        sb.append(((this.adminGroups == null)?"<null>":this.adminGroups));
        sb.append(',');
        sb.append("inputs");
        sb.append('=');
        sb.append(((this.inputs == null)?"<null>":this.inputs));
        sb.append(',');
        sb.append("outputs");
        sb.append('=');
        sb.append(((this.outputs == null)?"<null>":this.outputs));
        sb.append(',');
        sb.append("comments");
        sb.append('=');
        sb.append(((this.comments == null)?"<null>":this.comments));
        sb.append(',');
        sb.append("attachments");
        sb.append('=');
        sb.append(((this.attachments == null)?"<null>":this.attachments));
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
        result = ((result* 31)+((this.outputs == null)? 0 :this.outputs.hashCode()));
        result = ((result* 31)+((this.processInstanceId == null)? 0 :this.processInstanceId.hashCode()));
        result = ((result* 31)+((this.potentialUsers == null)? 0 :this.potentialUsers.hashCode()));
        result = ((result* 31)+((this.potentialGroups == null)? 0 :this.potentialGroups.hashCode()));
        result = ((result* 31)+((this.excludedUsers == null)? 0 :this.excludedUsers.hashCode()));
        result = ((result* 31)+((this.comments == null)? 0 :this.comments.hashCode()));
        result = ((result* 31)+((this.attachments == null)? 0 :this.attachments.hashCode()));
        result = ((result* 31)+((this.adminGroups == null)? 0 :this.adminGroups.hashCode()));
        result = ((result* 31)+((this.inputs == null)? 0 :this.inputs.hashCode()));
        result = ((result* 31)+((this.taskDescription == null)? 0 :this.taskDescription.hashCode()));
        result = ((result* 31)+((this.taskPriority == null)? 0 :this.taskPriority.hashCode()));
        result = ((result* 31)+((this.rootProcessId == null)? 0 :this.rootProcessId.hashCode()));
        result = ((result* 31)+((this.completeDate == null)? 0 :this.completeDate.hashCode()));
        result = ((result* 31)+((this.adminUsers == null)? 0 :this.adminUsers.hashCode()));
        result = ((result* 31)+((this.processId == null)? 0 :this.processId.hashCode()));
        result = ((result* 31)+((this.actualOwner == null)? 0 :this.actualOwner.hashCode()));
        result = ((result* 31)+((this.taskName == null)? 0 :this.taskName.hashCode()));
        result = ((result* 31)+((this.rootProcessInstanceId == null)? 0 :this.rootProcessInstanceId.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.state == null)? 0 :this.state.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.startDate == null)? 0 :this.startDate.hashCode()));
        result = ((result* 31)+((this.referenceName == null)? 0 :this.referenceName.hashCode()));
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
        return ((((((((((((((((((((((((this.outputs == rhs.outputs)||((this.outputs!= null)&&this.outputs.equals(rhs.outputs)))&&((this.processInstanceId == rhs.processInstanceId)||((this.processInstanceId!= null)&&this.processInstanceId.equals(rhs.processInstanceId))))&&((this.potentialUsers == rhs.potentialUsers)||((this.potentialUsers!= null)&&this.potentialUsers.equals(rhs.potentialUsers))))&&((this.potentialGroups == rhs.potentialGroups)||((this.potentialGroups!= null)&&this.potentialGroups.equals(rhs.potentialGroups))))&&((this.excludedUsers == rhs.excludedUsers)||((this.excludedUsers!= null)&&this.excludedUsers.equals(rhs.excludedUsers))))&&((this.comments == rhs.comments)||((this.comments!= null)&&this.comments.equals(rhs.comments))))&&((this.attachments == rhs.attachments)||((this.attachments!= null)&&this.attachments.equals(rhs.attachments))))&&((this.adminGroups == rhs.adminGroups)||((this.adminGroups!= null)&&this.adminGroups.equals(rhs.adminGroups))))&&((this.inputs == rhs.inputs)||((this.inputs!= null)&&this.inputs.equals(rhs.inputs))))&&((this.taskDescription == rhs.taskDescription)||((this.taskDescription!= null)&&this.taskDescription.equals(rhs.taskDescription))))&&((this.taskPriority == rhs.taskPriority)||((this.taskPriority!= null)&&this.taskPriority.equals(rhs.taskPriority))))&&((this.rootProcessId == rhs.rootProcessId)||((this.rootProcessId!= null)&&this.rootProcessId.equals(rhs.rootProcessId))))&&((this.completeDate == rhs.completeDate)||((this.completeDate!= null)&&this.completeDate.equals(rhs.completeDate))))&&((this.adminUsers == rhs.adminUsers)||((this.adminUsers!= null)&&this.adminUsers.equals(rhs.adminUsers))))&&((this.processId == rhs.processId)||((this.processId!= null)&&this.processId.equals(rhs.processId))))&&((this.actualOwner == rhs.actualOwner)||((this.actualOwner!= null)&&this.actualOwner.equals(rhs.actualOwner))))&&((this.taskName == rhs.taskName)||((this.taskName!= null)&&this.taskName.equals(rhs.taskName))))&&((this.rootProcessInstanceId == rhs.rootProcessInstanceId)||((this.rootProcessInstanceId!= null)&&this.rootProcessInstanceId.equals(rhs.rootProcessInstanceId))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.state == rhs.state)||((this.state!= null)&&this.state.equals(rhs.state))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.startDate == rhs.startDate)||((this.startDate!= null)&&this.startDate.equals(rhs.startDate))))&&((this.referenceName == rhs.referenceName)||((this.referenceName!= null)&&this.referenceName.equals(rhs.referenceName))));
    }

}
