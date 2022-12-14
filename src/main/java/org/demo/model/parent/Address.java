
package org.demo.model.parent;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @JsonProperty("street")
    private String street;
    @JsonProperty("city")
    private String city;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("country")
    private String country;

    public Address(org.demo.model.update.Address address) {
        this.street = address.getStreet();
        this.city = address.getCity();
        this.zipCode = address.getZipCode();
        this.country = address.getCountry();
    }
}
