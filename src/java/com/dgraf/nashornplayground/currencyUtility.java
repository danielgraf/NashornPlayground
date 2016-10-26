/* 
* To change this license header, choose License Headers in Project Properties. 
* To change this template file, choose Tools | Templates * and open the template in the editor. 
*/

package com.dgraf.nashornplayground;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
* * * 
@author dgraf 
*/

public class currencyUtility 
{
    public static final int EXCHANGE_RATE_LENGTH=11;
    public static final int MAX_EXCHANGE_RATE_DECIMALS=10;

    public currencyUtility()
    {
        currencies = new ArrayList<>();
        
        final URL resource = getClass().getResource("currencies.json");
        
            if (resource == null) 
            {
                throw new IllegalArgumentException("Currencies json file could be loaded from the classpath.");
            }

        try 
        {
            String cncydata = Resources.toString(resource, Charsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<currency> tmpCurrencies = mapper.readValue(cncydata, new TypeReference<ArrayList<currency>>() { });
            currencies.addAll(tmpCurrencies);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(currencyUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    private final ArrayList<currency> currencies;
    
    public currency findByAlphaCode(String alpha)
    {    
        for (currency t : currencies)
        {
            if (t.getAlphabeticCode().equalsIgnoreCase(alpha)) return t;
        }
        
        return null;
    }
    
    public currency findByNumericCode(int numeric)
    {
        for (currency t : currencies)
        {
            if (t.getNumericCode() == numeric) return t;
        }
        
        return null;
    }

    public String convertExchangeRateToISOFormat(BigDecimal decimal)
    {
        if (decimal == null) {
            throw new NumberFormatException("Null exchange rate");
        }
        if (decimal == BigDecimal.ZERO) {
            throw new NumberFormatException("Zero exchange rate");
        }
        int decimalPoints = decimal.scale();
        String result;
        if (decimalPoints == 0) {
            result = decimal.toString() + "0";
            decimalPoints = 1;
        } else {
            result = decimal.movePointRight(decimal.scale()).toString();
        }        
        if (decimalPoints > MAX_EXCHANGE_RATE_DECIMALS) {
            result = result.substring(0, result.length() - (decimalPoints - MAX_EXCHANGE_RATE_DECIMALS));
            decimalPoints = MAX_EXCHANGE_RATE_DECIMALS;
        }
        if (result.length() > EXCHANGE_RATE_LENGTH) {
            decimalPoints = decimalPoints - (result.length() - EXCHANGE_RATE_LENGTH);
            result = result.substring(0, EXCHANGE_RATE_LENGTH);
        } else {
            while (result.length() < EXCHANGE_RATE_LENGTH) {
                result = "0" + result;
            }
        }
        if (decimalPoints == MAX_EXCHANGE_RATE_DECIMALS) {
            result = "0" + result;
        } else {
            result = decimalPoints + result;
        }
        return result;
    }

    public BigDecimal convertISOFormatToExchangeRate(String isoInput)
    {
        if (isoInput == null) {
            throw new NumberFormatException("Null exchange rate");
        }
        if (isoInput.isEmpty()) {
            throw new NumberFormatException("Empty exchange rate");
        }  
        int decimalPoints;
        BigDecimal result = BigDecimal.ZERO;
        try {
            decimalPoints = Integer.parseInt(isoInput.substring(0, 1));
            if (decimalPoints == 0) {
                decimalPoints = MAX_EXCHANGE_RATE_DECIMALS;
            }
            result = new BigDecimal(isoInput.substring(1));
        } catch (NumberFormatException formatException) {
            throw new IllegalArgumentException("Invalid exchange rate");
        }        
        result = result.movePointLeft(decimalPoints);
        if (result.compareTo(BigDecimal.ZERO) == 0) {
            throw new NumberFormatException("Zero exchange rate");
        }
        return result;
    }

}

