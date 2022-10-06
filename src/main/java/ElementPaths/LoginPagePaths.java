package ElementPaths;

public interface LoginPagePaths {
    String emailOrNumberInputField = "input.form-control.prepended-form-control[onkeyup=\"if(this.value != ''){$('#si-email-error').html('')}\"]";
    String passwordInputField = "input.form-control.prepended-form-control[onkeyup=\"if(this.value != ''){$('#si-password-error').html('')}\"]";
    String signInButton = "button#sign-in";
    String homeSignInButton = "body > div.style2 > header > div > div.navbar.navbar-expand-lg.navbar-light.resp-height > div > div > div.col-lg-auto.order-lg-3 > div > div > ul > li:nth-child(4) > a";
    String accountButton = "body > div.style2 > header > div > div.navbar.navbar-expand-lg.navbar-light.resp-height > div > div > div.col-lg-auto.order-lg-3 > div > div > ul > li:nth-child(4) > div > a";
    String logoutButton = "#form-button";

}
