package ElementPaths;

import lombok.experimental.Helper;

public interface PayFortPagePaths {
    String countryDropDown = "div.cs-select.cs-skin-border.cs-skin-elastic.country>span";
    String bankDropDown = "div.cs-select.cs-skin-border.cs-skin-elastic.issuer>span";
    String installmentTypeDropDown = "div.cs-select.cs-skin-border.full-width.cs-skin-elastic>span";
    String cardHolderName = "input[name=\"customer_name\"]";
    String cardNumber = "input[name=\"card_number\"]";
    String expiryDate = "input[name=\"expDate\"]";
    String CVV_Code = "input[name=\"card_security_code\"]";
    String agreementCheckBox = "input[name=\"bank\"]";
    String payButton = "input[name=\"bank\"]";


}
