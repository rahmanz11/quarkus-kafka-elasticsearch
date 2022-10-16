
package org.demo.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "nodeId",
    "nodeDefinitionId",
    "nodeName",
    "nodeType",
    "triggerTime",
    "leaveTime"
})
@Generated("jsonschema2pojo")
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

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("nodeId")
    public String getNodeId() {
        return nodeId;
    }

    @JsonProperty("nodeId")
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    @JsonProperty("nodeDefinitionId")
    public String getNodeDefinitionId() {
        return nodeDefinitionId;
    }

    @JsonProperty("nodeDefinitionId")
    public void setNodeDefinitionId(String nodeDefinitionId) {
        this.nodeDefinitionId = nodeDefinitionId;
    }

    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    @JsonProperty("nodeType")
    public String getNodeType() {
        return nodeType;
    }

    @JsonProperty("nodeType")
    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    @JsonProperty("triggerTime")
    public String getTriggerTime() {
        return triggerTime;
    }

    @JsonProperty("triggerTime")
    public void setTriggerTime(String triggerTime) {
        this.triggerTime = triggerTime;
    }

    @JsonProperty("leaveTime")
    public String getLeaveTime() {
        return leaveTime;
    }

    @JsonProperty("leaveTime")
    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NodeInstance.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("nodeId");
        sb.append('=');
        sb.append(((this.nodeId == null)?"<null>":this.nodeId));
        sb.append(',');
        sb.append("nodeDefinitionId");
        sb.append('=');
        sb.append(((this.nodeDefinitionId == null)?"<null>":this.nodeDefinitionId));
        sb.append(',');
        sb.append("nodeName");
        sb.append('=');
        sb.append(((this.nodeName == null)?"<null>":this.nodeName));
        sb.append(',');
        sb.append("nodeType");
        sb.append('=');
        sb.append(((this.nodeType == null)?"<null>":this.nodeType));
        sb.append(',');
        sb.append("triggerTime");
        sb.append('=');
        sb.append(((this.triggerTime == null)?"<null>":this.triggerTime));
        sb.append(',');
        sb.append("leaveTime");
        sb.append('=');
        sb.append(((this.leaveTime == null)?"<null>":this.leaveTime));
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
        result = ((result* 31)+((this.nodeName == null)? 0 :this.nodeName.hashCode()));
        result = ((result* 31)+((this.leaveTime == null)? 0 :this.leaveTime.hashCode()));
        result = ((result* 31)+((this.nodeDefinitionId == null)? 0 :this.nodeDefinitionId.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.nodeType == null)? 0 :this.nodeType.hashCode()));
        result = ((result* 31)+((this.triggerTime == null)? 0 :this.triggerTime.hashCode()));
        result = ((result* 31)+((this.nodeId == null)? 0 :this.nodeId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NodeInstance) == false) {
            return false;
        }
        NodeInstance rhs = ((NodeInstance) other);
        return ((((((((this.nodeName == rhs.nodeName)||((this.nodeName!= null)&&this.nodeName.equals(rhs.nodeName)))&&((this.leaveTime == rhs.leaveTime)||((this.leaveTime!= null)&&this.leaveTime.equals(rhs.leaveTime))))&&((this.nodeDefinitionId == rhs.nodeDefinitionId)||((this.nodeDefinitionId!= null)&&this.nodeDefinitionId.equals(rhs.nodeDefinitionId))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.nodeType == rhs.nodeType)||((this.nodeType!= null)&&this.nodeType.equals(rhs.nodeType))))&&((this.triggerTime == rhs.triggerTime)||((this.triggerTime!= null)&&this.triggerTime.equals(rhs.triggerTime))))&&((this.nodeId == rhs.nodeId)||((this.nodeId!= null)&&this.nodeId.equals(rhs.nodeId))));
    }

}
