
package org.demo.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "deal",
    "TaskName",
    "NodeName",
    "Skippable",
    "ActorId",
    "traveller"
})
@Generated("jsonschema2pojo")
public class Inputs {

    @JsonProperty("deal")
    private String deal;
    @JsonProperty("TaskName")
    private String taskName;
    @JsonProperty("NodeName")
    private String nodeName;
    @JsonProperty("Skippable")
    private String skippable;
    @JsonProperty("ActorId")
    private String actorId;
    @JsonProperty("traveller")
    private Traveller traveller;

    @JsonProperty("deal")
    public String getDeal() {
        return deal;
    }

    @JsonProperty("deal")
    public void setDeal(String deal) {
        this.deal = deal;
    }

    @JsonProperty("TaskName")
    public String getTaskName() {
        return taskName;
    }

    @JsonProperty("TaskName")
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @JsonProperty("NodeName")
    public String getNodeName() {
        return nodeName;
    }

    @JsonProperty("NodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    @JsonProperty("Skippable")
    public String getSkippable() {
        return skippable;
    }

    @JsonProperty("Skippable")
    public void setSkippable(String skippable) {
        this.skippable = skippable;
    }

    @JsonProperty("ActorId")
    public String getActorId() {
        return actorId;
    }

    @JsonProperty("ActorId")
    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    @JsonProperty("traveller")
    public Traveller getTraveller() {
        return traveller;
    }

    @JsonProperty("traveller")
    public void setTraveller(Traveller traveller) {
        this.traveller = traveller;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Inputs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("deal");
        sb.append('=');
        sb.append(((this.deal == null)?"<null>":this.deal));
        sb.append(',');
        sb.append("taskName");
        sb.append('=');
        sb.append(((this.taskName == null)?"<null>":this.taskName));
        sb.append(',');
        sb.append("nodeName");
        sb.append('=');
        sb.append(((this.nodeName == null)?"<null>":this.nodeName));
        sb.append(',');
        sb.append("skippable");
        sb.append('=');
        sb.append(((this.skippable == null)?"<null>":this.skippable));
        sb.append(',');
        sb.append("actorId");
        sb.append('=');
        sb.append(((this.actorId == null)?"<null>":this.actorId));
        sb.append(',');
        sb.append("traveller");
        sb.append('=');
        sb.append(((this.traveller == null)?"<null>":this.traveller));
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
        result = ((result* 31)+((this.deal == null)? 0 :this.deal.hashCode()));
        result = ((result* 31)+((this.actorId == null)? 0 :this.actorId.hashCode()));
        result = ((result* 31)+((this.taskName == null)? 0 :this.taskName.hashCode()));
        result = ((result* 31)+((this.skippable == null)? 0 :this.skippable.hashCode()));
        result = ((result* 31)+((this.traveller == null)? 0 :this.traveller.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Inputs) == false) {
            return false;
        }
        Inputs rhs = ((Inputs) other);
        return (((((((this.nodeName == rhs.nodeName)||((this.nodeName!= null)&&this.nodeName.equals(rhs.nodeName)))&&((this.deal == rhs.deal)||((this.deal!= null)&&this.deal.equals(rhs.deal))))&&((this.actorId == rhs.actorId)||((this.actorId!= null)&&this.actorId.equals(rhs.actorId))))&&((this.taskName == rhs.taskName)||((this.taskName!= null)&&this.taskName.equals(rhs.taskName))))&&((this.skippable == rhs.skippable)||((this.skippable!= null)&&this.skippable.equals(rhs.skippable))))&&((this.traveller == rhs.traveller)||((this.traveller!= null)&&this.traveller.equals(rhs.traveller))));
    }

}
