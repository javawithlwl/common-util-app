package com.careerit.cup.jsoninheritance;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VertexAuthInfo extends  TaxVendorAuth{
    private String trustedId;
    public VertexAuthInfo(){
        super(TaxVendor.VERTEX);
    }
}
