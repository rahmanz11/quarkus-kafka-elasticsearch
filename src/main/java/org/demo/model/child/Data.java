
package org.demo.model.child;

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
    private Object outputs;
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
}
