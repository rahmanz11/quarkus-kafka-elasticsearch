
package org.demo.model.parent;

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
    "deal",
    "traveller",
    "review"
})
@Generated("jsonschema2pojo")
public class Variables {

    @JsonProperty("deal")
    private String deal;
    @JsonProperty("traveller")
    private Traveller traveller;
    @JsonProperty("review")
    private String review;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("deal")
    public String getDeal() {
        return deal;
    }

    @JsonProperty("deal")
    public void setDeal(String deal) {
        this.deal = deal;
    }

    @JsonProperty("traveller")
    public Traveller getTraveller() {
        return traveller;
    }

    @JsonProperty("traveller")
    public void setTraveller(Traveller traveller) {
        this.traveller = traveller;
    }

    @JsonProperty("review")
    public String getReview() {
        return review;
    }

    @JsonProperty("review")
    public void setReview(String review) {
        this.review = review;
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
        sb.append(Variables.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("deal");
        sb.append('=');
        sb.append(((this.deal == null)?"<null>":this.deal));
        sb.append(',');
        sb.append("traveller");
        sb.append('=');
        sb.append(((this.traveller == null)?"<null>":this.traveller));
        sb.append(',');
        sb.append("review");
        sb.append('=');
        sb.append(((this.review == null)?"<null>":this.review));
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
        result = ((result* 31)+((this.deal == null)? 0 :this.deal.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.traveller == null)? 0 :this.traveller.hashCode()));
        result = ((result* 31)+((this.review == null)? 0 :this.review.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Variables) == false) {
            return false;
        }
        Variables rhs = ((Variables) other);
        return (((((this.deal == rhs.deal)||((this.deal!= null)&&this.deal.equals(rhs.deal)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.traveller == rhs.traveller)||((this.traveller!= null)&&this.traveller.equals(rhs.traveller))))&&((this.review == rhs.review)||((this.review!= null)&&this.review.equals(rhs.review))));
    }

}
