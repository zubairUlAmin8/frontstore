package ElementPaths;

public interface LoginPagePaths {
    String emailOrNumberInputField = "input.form-control.prepended-form-control[onkeyup=\"if(this.value != ''){$('#si-email-error').html('')}\"]";
    String passwordInputField = "input.form-control.prepended-form-control[onkeyup=\"if(this.value != ''){$('#si-password-error').html('')}\"]";
    String eyeIcon = "#signin-tab > div > div > div > div.col-lg-6.col-md-6.col-sm-12 > div.form-group.mb-2 > div > label";
    String signInButton = "button#sign-in";
    String homeSignInButton = "body > div.style2 > header > div > div.navbar.navbar-expand-lg.navbar-light.resp-height > div > div > div.col-lg-auto.order-lg-3 > div > div > ul > li:nth-child(4) > a";
    String accountButton = "body > div.style2 > header > div > div.navbar.navbar-expand-lg.navbar-light.resp-height > div > div > div.col-lg-auto.order-lg-3 > div > div > ul > li:nth-child(4) > div > a";
    String logoutButton = "#form-button";
    String modalCloseButton = "#signin-tab > div > div > div > div.col-md-12 > div > button";
    // Social Login Xpath's
    String fbLoginButton = "#signin-tab > div > div > div > div.col-lg-5.col-md-5.col-sm-12.pl-lg-4 > div > div > a.fb_login";
    String gmailLoginButton = "#signin-tab > div > div > div > div.col-lg-5.col-md-5.col-sm-12.pl-lg-4 > div > div > a:nth-child(2)";
    String otpLoginButton = "#signin-tab > div > div > div > div.col-lg-5.col-md-5.col-sm-12.pl-lg-4 > div > div > a:nth-child(3)";
    // Facebook Xpath's
    String fbEmail = "#email";
    String fbPassword = "#pass";
    String fbButton = "#loginbutton";

}
