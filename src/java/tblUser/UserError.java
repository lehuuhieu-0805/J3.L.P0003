/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblUser;

/**
 *
 * @author lehuuhieu
 */
public class UserError {

    private String emailError, phoneError, nameError, addressError, passwordError, confirmPasswordError, userError;

    public UserError() {
    }

    public UserError(String emailError, String phoneError, String nameError, String addressError, String passwordError, String confirmPasswordError, String userError) {
        this.emailError = emailError;
        this.phoneError = phoneError;
        this.nameError = nameError;
        this.addressError = addressError;
        this.passwordError = passwordError;
        this.confirmPasswordError = confirmPasswordError;
        this.userError = userError;
    }

    public String getUserError() {
        return userError;
    }

    public void setUserError(String userError) {
        this.userError = userError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmPasswordError() {
        return confirmPasswordError;
    }

    public void setConfirmPasswordError(String confirmPasswordError) {
        this.confirmPasswordError = confirmPasswordError;
    }

}
