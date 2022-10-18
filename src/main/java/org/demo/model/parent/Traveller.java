
package org.demo.model.parent;

import org.demo.model.update.VariableValue;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Traveller {

    @JsonProperty("text")
    private String text;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("nationality")
    private String nationality;
    @JsonProperty("address")
    private Address address;

    public Traveller(VariableValue val) {
        this.text = val.getText();
        this.firstName = val.getFirstName();
        this.lastName = val.getLastName();
        this.email = val.getEmail();
        this.nationality = val.getNationality();
        this.address = new Address(val.getAddress());
    }
}
