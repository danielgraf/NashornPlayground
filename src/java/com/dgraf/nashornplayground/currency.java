/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgraf.nashornplayground;

/**
 *
 * @author dgraf
 */
public class currency {
    
    public currency()
    {
        entity = "";
        currency = "";
        alphabeticCode = "";
        numericCode = -1;
        minorUnit = "";
        withdrawalDate = "";
        remark = "";
        
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String Entity) {
        this.entity = Entity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String Currency) {
        this.currency = Currency;
    }

    public String getAlphabeticCode() {
        return alphabeticCode;
    }

    public void setAlphabeticCode(String AlphabeticCode) {
        this.alphabeticCode = AlphabeticCode;
    }

    public int getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(int NumericCode) {
        this.numericCode = NumericCode;
    }

    public String getMinorUnit() {
        return minorUnit;
    }

    public void setMinorUnit(String MinorUnit) {
        this.minorUnit = MinorUnit;
    }

    public String getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(String WithdrawalDate) {
        this.withdrawalDate = WithdrawalDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String Remark) {
        this.remark = Remark;
    }
    
    private String entity;
    private String currency;

    
    private String alphabeticCode;
    private int numericCode;
    private String minorUnit;
    private String withdrawalDate;
    private String remark;
            

    
}
