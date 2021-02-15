/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haway.tbl_user;

import java.io.Serializable;

/**
 *
 * @author haway
 */
public class Tbl_UserInsertError implements Serializable {  
    private String userIDLengthErr;
    private String passwordLengthErr;
    private String confirmNotMatch;
    private String fullNameLengthErr;
    private String userIDisExisted;

    public Tbl_UserInsertError() {
    }

    public Tbl_UserInsertError(String userIDLengthErr, String passwordLengthErr, String confirmNotMatch, String fullNameLengthErr, String userIDisExisted) {
        this.userIDLengthErr = userIDLengthErr;
        this.passwordLengthErr = passwordLengthErr;
        this.confirmNotMatch = confirmNotMatch;
        this.fullNameLengthErr = fullNameLengthErr;
        this.userIDisExisted = userIDisExisted;
    }

    public String getUserIDLengthErr() {
        return userIDLengthErr;
    }

    public void setUserIDLengthErr(String userIDLengthErr) {
        this.userIDLengthErr = userIDLengthErr;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public String getConfirmNotMatch() {
        return confirmNotMatch;
    }

    public void setConfirmNotMatch(String confirmNotMatch) {
        this.confirmNotMatch = confirmNotMatch;
    }

    public String getFullNameLengthErr() {
        return fullNameLengthErr;
    }

    public void setFullNameLengthErr(String fullNameLengthErr) {
        this.fullNameLengthErr = fullNameLengthErr;
    }

    public String getUserIDisExisted() {
        return userIDisExisted;
    }

    public void setUserIDisExisted(String userIDisExisted) {
        this.userIDisExisted = userIDisExisted;
    }
    
}
