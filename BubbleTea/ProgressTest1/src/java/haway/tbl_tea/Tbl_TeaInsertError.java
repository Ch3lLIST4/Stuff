/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haway.tbl_tea;

import java.io.Serializable;

/**
 *
 * @author haway
 */
public class Tbl_TeaInsertError implements Serializable {
    private String teaIDLengthErr;
    private String nameLengthErr;
    private String priceFormatErr;
    private String teaIDisExisted;

    public Tbl_TeaInsertError() {
    }

    public Tbl_TeaInsertError(String teaIDLengthErr, String nameLengthErr, String priceFormatErr, String teaIDisExisted) {
        this.teaIDLengthErr = teaIDLengthErr;
        this.nameLengthErr = nameLengthErr;
        this.priceFormatErr = priceFormatErr;
        this.teaIDisExisted = teaIDisExisted;
    }

    public String getTeaIDLengthErr() {
        return teaIDLengthErr;
    }

    public void setTeaIDLengthErr(String teaIDLengthErr) {
        this.teaIDLengthErr = teaIDLengthErr;
    }

    public String getNameLengthErr() {
        return nameLengthErr;
    }

    public void setNameLengthErr(String nameLengthErr) {
        this.nameLengthErr = nameLengthErr;
    }

    public String getPriceFormatErr() {
        return priceFormatErr;
    }

    public void setPriceFormatErr(String priceFormatErr) {
        this.priceFormatErr = priceFormatErr;
    }

    public String getTeaIDisExisted() {
        return teaIDisExisted;
    }

    public void setTeaIDisExisted(String teaIDisExisted) {
        this.teaIDisExisted = teaIDisExisted;
    }
    
}
