
package org.demo.model.child;

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
    "id",
    "source",
    "type",
    "time",
    "data",
    "specversion",
    "kogitoprocinstanceid",
    "kogitoprocid",
    "kogitoaddons",
    "kogitousertaskiid",
    "kogitousertaskist"
})
@Generated("jsonschema2pojo")
public class Child {

    @JsonProperty("id")
    private String id;
    @JsonProperty("source")
    private String source;
    @JsonProperty("type")
    private String type;
    @JsonProperty("time")
    private String time;
    @JsonProperty("data")
    private Data data;
    @JsonProperty("specversion")
    private String specversion;
    @JsonProperty("kogitoprocinstanceid")
    private String kogitoprocinstanceid;
    @JsonProperty("kogitoprocid")
    private String kogitoprocid;
    @JsonProperty("kogitoaddons")
    private String kogitoaddons;
    @JsonProperty("kogitousertaskiid")
    private String kogitousertaskiid;
    @JsonProperty("kogitousertaskist")
    private String kogitousertaskist;
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

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    @JsonProperty("specversion")
    public String getSpecversion() {
        return specversion;
    }

    @JsonProperty("specversion")
    public void setSpecversion(String specversion) {
        this.specversion = specversion;
    }

    @JsonProperty("kogitoprocinstanceid")
    public String getKogitoprocinstanceid() {
        return kogitoprocinstanceid;
    }

    @JsonProperty("kogitoprocinstanceid")
    public void setKogitoprocinstanceid(String kogitoprocinstanceid) {
        this.kogitoprocinstanceid = kogitoprocinstanceid;
    }

    @JsonProperty("kogitoprocid")
    public String getKogitoprocid() {
        return kogitoprocid;
    }

    @JsonProperty("kogitoprocid")
    public void setKogitoprocid(String kogitoprocid) {
        this.kogitoprocid = kogitoprocid;
    }

    @JsonProperty("kogitoaddons")
    public String getKogitoaddons() {
        return kogitoaddons;
    }

    @JsonProperty("kogitoaddons")
    public void setKogitoaddons(String kogitoaddons) {
        this.kogitoaddons = kogitoaddons;
    }

    @JsonProperty("kogitousertaskiid")
    public String getKogitousertaskiid() {
        return kogitousertaskiid;
    }

    @JsonProperty("kogitousertaskiid")
    public void setKogitousertaskiid(String kogitousertaskiid) {
        this.kogitousertaskiid = kogitousertaskiid;
    }

    @JsonProperty("kogitousertaskist")
    public String getKogitousertaskist() {
        return kogitousertaskist;
    }

    @JsonProperty("kogitousertaskist")
    public void setKogitousertaskist(String kogitousertaskist) {
        this.kogitousertaskist = kogitousertaskist;
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
        sb.append(Child.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("source");
        sb.append('=');
        sb.append(((this.source == null)?"<null>":this.source));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("time");
        sb.append('=');
        sb.append(((this.time == null)?"<null>":this.time));
        sb.append(',');
        sb.append("data");
        sb.append('=');
        sb.append(((this.data == null)?"<null>":this.data));
        sb.append(',');
        sb.append("specversion");
        sb.append('=');
        sb.append(((this.specversion == null)?"<null>":this.specversion));
        sb.append(',');
        sb.append("kogitoprocinstanceid");
        sb.append('=');
        sb.append(((this.kogitoprocinstanceid == null)?"<null>":this.kogitoprocinstanceid));
        sb.append(',');
        sb.append("kogitoprocid");
        sb.append('=');
        sb.append(((this.kogitoprocid == null)?"<null>":this.kogitoprocid));
        sb.append(',');
        sb.append("kogitoaddons");
        sb.append('=');
        sb.append(((this.kogitoaddons == null)?"<null>":this.kogitoaddons));
        sb.append(',');
        sb.append("kogitousertaskiid");
        sb.append('=');
        sb.append(((this.kogitousertaskiid == null)?"<null>":this.kogitousertaskiid));
        sb.append(',');
        sb.append("kogitousertaskist");
        sb.append('=');
        sb.append(((this.kogitousertaskist == null)?"<null>":this.kogitousertaskist));
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
        result = ((result* 31)+((this.data == null)? 0 :this.data.hashCode()));
        result = ((result* 31)+((this.source == null)? 0 :this.source.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.kogitoprocid == null)? 0 :this.kogitoprocid.hashCode()));
        result = ((result* 31)+((this.kogitoaddons == null)? 0 :this.kogitoaddons.hashCode()));
        result = ((result* 31)+((this.kogitousertaskist == null)? 0 :this.kogitousertaskist.hashCode()));
        result = ((result* 31)+((this.specversion == null)? 0 :this.specversion.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.time == null)? 0 :this.time.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.kogitoprocinstanceid == null)? 0 :this.kogitoprocinstanceid.hashCode()));
        result = ((result* 31)+((this.kogitousertaskiid == null)? 0 :this.kogitousertaskiid.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Child) == false) {
            return false;
        }
        Child rhs = ((Child) other);
        return (((((((((((((this.data == rhs.data)||((this.data!= null)&&this.data.equals(rhs.data)))&&((this.source == rhs.source)||((this.source!= null)&&this.source.equals(rhs.source))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.kogitoprocid == rhs.kogitoprocid)||((this.kogitoprocid!= null)&&this.kogitoprocid.equals(rhs.kogitoprocid))))&&((this.kogitoaddons == rhs.kogitoaddons)||((this.kogitoaddons!= null)&&this.kogitoaddons.equals(rhs.kogitoaddons))))&&((this.kogitousertaskist == rhs.kogitousertaskist)||((this.kogitousertaskist!= null)&&this.kogitousertaskist.equals(rhs.kogitousertaskist))))&&((this.specversion == rhs.specversion)||((this.specversion!= null)&&this.specversion.equals(rhs.specversion))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.time == rhs.time)||((this.time!= null)&&this.time.equals(rhs.time))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.kogitoprocinstanceid == rhs.kogitoprocinstanceid)||((this.kogitoprocinstanceid!= null)&&this.kogitoprocinstanceid.equals(rhs.kogitoprocinstanceid))))&&((this.kogitousertaskiid == rhs.kogitousertaskiid)||((this.kogitousertaskiid!= null)&&this.kogitousertaskiid.equals(rhs.kogitousertaskiid))));
    }

}