package com.careerit.cup.jsoninheritance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDetails {
    private String name;
    private TaxVendorAuth taxVendorAuth;
}
