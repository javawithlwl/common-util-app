package com.careerit.cup.jsoninheritance;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "taxVendor",
    visible = true
)
@JsonSubTypes({
      @JsonSubTypes.Type(value = VertexAuthInfo.class,name = "VERTEX"),
      @JsonSubTypes.Type(value = AvalaraAuthInfo.class,name = "AVALARA"),
})
@Getter
@Setter
@AllArgsConstructor
public abstract class TaxVendorAuth implements Serializable {
     private TaxVendor taxVendor;
}
