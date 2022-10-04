package ElementPaths;

public interface CheckOutPagePaths {
    String codRadioButton = "label[for=\"payment-type-cod\"]";
    String placeOrderButton = "a.btn.d-block.mt-3.btn-primary[href=\"javascript:void(0);\"]";
    String cardNumberInputField = "input[type=\"tel\"][id=\"card_number\"]";
    String cardExpiryMonth = "input#expiry_month";
    String cardExpiryYear = "input#expiry_year";
    String CVV_CodeInputField = "input#card_security_code";
    String cardHolderNameInputFiled = "input#card_holder_name";
    String payNowButton = "button#checkout-submit-btn";


}
