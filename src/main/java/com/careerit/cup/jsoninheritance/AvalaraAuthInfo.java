package com.careerit.cup.jsoninheritance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvalaraAuthInfo extends  TaxVendorAuth {

  private String userName;
  private String password;

  public AvalaraAuthInfo(){
      super(TaxVendor.AVALARA);
  }

}
