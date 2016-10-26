// "currency" is a Java class bound into the script engine
// it offers handy currency lookup utilities

// Here we use it to find two currencies by their ISO Alpha-3 codes
var GBP = currency.findByAlphaCode("GBP");
var CHF = currency.findByAlphaCode("CHF");

// And now we can output the name and ISO numeric codes
print(GBP.getCurrency() + " ISO numeric code : " + GBP.getNumericCode());
print(CHF.getCurrency() + " ISO numeric code : " + CHF.getNumericCode());
