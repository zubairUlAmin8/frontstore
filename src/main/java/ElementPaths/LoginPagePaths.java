package ElementPaths;

public interface LoginPagePaths {
    String emailOrNumberInputField = "input.form-control.prepended-form-control[onkeyup=\"if(this.value != ''){$('#si-email-error').html('')}\"]";
    String passwordInputField = "input.form-control.prepended-form-control[onkeyup=\"if(this.value != ''){$('#si-password-error').html('')}\"]";
    String signInButton = "button#sign-in";

}
